package com.bjoernkw.sampleforpossiblecsrftokenbuginspringsecurity6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler;

@Configuration
public class WebSecurityConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // see https://docs.spring.io/spring-security/reference/5.8/migration/servlet/exploits.html
        CookieCsrfTokenRepository tokenRepository = CookieCsrfTokenRepository.withHttpOnlyFalse();
        XorCsrfTokenRequestAttributeHandler delegate = new XorCsrfTokenRequestAttributeHandler();
        delegate.setCsrfRequestAttributeName("_csrf");

        return http
                .authorizeHttpRequests(
                        authorize ->
                                authorize
                                        .requestMatchers(
                                                "/sample/**"
                                        ).permitAll()
                                        .anyRequest().authenticated()
                )
                .csrf(
                        csrf -> csrf
                                .csrfTokenRepository(tokenRepository)
                                .csrfTokenRequestHandler(delegate)
                )
                .build();
    }
}
