package com.fredrikpedersen.brewery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String[] nonSecuredMvcPaths = new String[]{"/", "/webjars/**", "/login", "/resources/**", "/beers/find", "/beers*"};

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder(); //Default is BCrypt
    }

    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception {
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

    @Override
    protected void configure(final AuthenticationManagerBuilder authenticationManager) throws Exception {
        authenticationManager.inMemoryAuthentication().withUser("admin").password("{bcrypt}$2a$10$lTeAU7EZPHkjL/aX0eWvS.a8eWfvAaGF6xgDrynSFIZCi2oynchT6").roles("ADMIN");
        authenticationManager.inMemoryAuthentication().withUser("user").password("{bcrypt}$2a$10$L/VBtz7841kBDS.y2b2B/uBv77WPOOEy7dU/FkLcYKhJlsN6IwKJ.").roles("USER");
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
