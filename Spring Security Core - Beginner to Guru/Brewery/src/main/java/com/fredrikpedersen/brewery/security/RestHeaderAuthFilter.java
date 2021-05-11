package com.fredrikpedersen.brewery.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class RestHeaderAuthFilter extends AbstractAuthenticationProcessingFilter {

    public RestHeaderAuthFilter(final RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        if (logger.isDebugEnabled()) {
            logger.debug("Request is to process authentication");
        }

        try {
            final Authentication authResult = attemptAuthentication(request, response);

            if (authResult == null) {
                chain.doFilter(request, response);
            } else {
                successfulAuthentication(request, response, chain, authResult);
            }
        } catch (AuthenticationException e) {
            log.error("Authentication failed", e);
            unsuccessfulAuthentication(request, response, e);
        }
    }

    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response) throws AuthenticationException {
        String userName = getUsernameFromRequest(request);
        String password = getPasswordFromRequest(request);

        if (userName == null) {
            userName = "";
        }

        if (password == null) {
            password = "";
        }

        log.debug("Authenticating user: " + userName);
        final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password);

        return StringUtils.isEmpty(userName) ? null : this.getAuthenticationManager().authenticate(token);
    }

    @Override
    protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain, final Authentication authResult) {

        if (logger.isDebugEnabled()) {
            logger.debug("Authentication success. Updating SecurityContextHolder to contain: " + authResult);
        }

        SecurityContextHolder.getContext().setAuthentication(authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException failed) throws IOException {
        SecurityContextHolder.clearContext();

        if (log.isDebugEnabled()) {
            log.debug("Authentication request failed: " + failed.toString(), failed);
            log.debug("Updated SecurityContextHolder to contain null Authentication");
        }

        response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }

    private String getPasswordFromRequest(final HttpServletRequest request) {
        return request.getHeader("Api-Secret");
    }

    private String getUsernameFromRequest(final HttpServletRequest request) {
        return request.getHeader("Api-Key");
    }
}
