package com.my.poc.springcloudgatewayreactivesecurityapproach2.security;

import com.my.poc.springcloudgatewayreactivesecurityapproach2.document.CustomDocumentAuthenticationWebFilter;
import com.my.poc.springcloudgatewayreactivesecurityapproach2.document.CustomDocumentServerAuthenticationConverter;
import com.my.poc.springcloudgatewayreactivesecurityapproach2.document.CustomDocumentServerAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Autowired
    private CustomReactiveAuthenticationManager customReactiveAuthenticationManager;

    @Autowired
    private CustomDocumentServerAuthenticationConverter customDocumentServerAuthenticationConverter;

    @Autowired
    private CustomDocumentServerAuthenticationSuccessHandler customDocumentServerAuthenticationSuccessHandler;

    private final ServerWebExchangeMatcher documentMatcher = new PathPatternParserServerWebExchangeMatcher("/api/document");

    @Bean
    SecurityWebFilterChain documentWebFilterChain(ServerHttpSecurity http) {

        CustomDocumentAuthenticationWebFilter customDocumentAuthenticationWebFilter = new CustomDocumentAuthenticationWebFilter(
                customReactiveAuthenticationManager,
                customDocumentServerAuthenticationConverter,
                customDocumentServerAuthenticationSuccessHandler
        );

        return http
                .securityMatcher(ServerWebExchangeMatchers.matchers(documentMatcher))
                .addFilterAt(customDocumentAuthenticationWebFilter, SecurityWebFiltersOrder.FIRST)
                .authorizeExchange().anyExchange().authenticated()
                .and().headers()
                .contentSecurityPolicy(String.join("; ", "frame-ancestors 'self'"))
                .and().hsts().disable()
                .and().csrf().disable()
                .build();
    }
}
