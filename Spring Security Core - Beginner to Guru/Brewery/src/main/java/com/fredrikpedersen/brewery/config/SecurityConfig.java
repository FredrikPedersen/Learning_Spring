package com.fredrikpedersen.brewery.config;

import com.fredrikpedersen.brewery.security.DomainPasswordEncoderFactories;
import com.fredrikpedersen.brewery.security.RestHeaderAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String[] nonSecuredMvcPaths = new String[]{"/", "/webjars/**", "/login", "/resources/**", "/beers/find", "/beers*"};

    public RestHeaderAuthFilter restHeaderAuthFilter(final AuthenticationManager authenticationManager) {
        final RestHeaderAuthFilter filter = new RestHeaderAuthFilter(new AntPathRequestMatcher("/api/**"));
        filter.setAuthenticationManager(authenticationManager);

        return filter;
    }

    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(restHeaderAuthFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class); //Adds restHeaderAuthFilter to execute before the UPAFilter in the filter chain.

        httpSecurity
                .authorizeRequests(authorize -> authorize
                        .antMatchers(nonSecuredMvcPaths).permitAll()
                        .antMatchers(HttpMethod.GET, "/api/v1/beer/**").permitAll()
                        .mvcMatchers(HttpMethod.GET, "/api/v1/beerUpc/{upc}").permitAll())
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return DomainPasswordEncoderFactories.createDelegatingPasswordEncoder(); //Default is BCrypt
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder authenticationManager) throws Exception {
        authenticationManager.inMemoryAuthentication().withUser("admin").password("{bcrypt15}$2a$15$FQRQXaep0Baydaf7W8luO.lh5Y8w4wPIjoE8vujM1/tThMeQubQnm").roles("ADMIN");
        authenticationManager.inMemoryAuthentication().withUser("user").password("{sha256}563234b3bbc4975ca08d77918b816a07493e0634c7a6bd3fbb5bebb3d25e32b1172e09fb51ec0ac6").roles("USER");
    }

    //Other method for configuring in-memory userDetails
    /*@Bean
    @Override
    protected UserDetailsService userDetailsService() {
        final UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("pw")
                .roles("ADMIN")
                .build();

        final UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("pw")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    } */
}
