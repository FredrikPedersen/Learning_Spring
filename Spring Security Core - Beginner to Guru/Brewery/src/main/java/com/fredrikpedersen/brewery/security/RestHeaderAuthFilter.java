package com.fredrikpedersen.brewery.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class RestHeaderAuthFilter extends AbstractAuthenticationProcessingFilter {

    public RestHeaderAuthFilter(final RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String userName = getUsername(request);
        String password = getPassword(request);

        if (userName == null) {
            userName = "";
        }

        if (password == null) {
            password = "";
        }

        log.debug("Authenticating user: " + userName);

        final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password);
        return this.getAuthenticationManager().authenticate(token);
    }

    private String getPassword(final HttpServletRequest request) {
        return request.getHeader("Api-Secret");
    }

    private String getUsername(final HttpServletRequest request) {
        return request.getHeader("Api-Key");
    }
}
