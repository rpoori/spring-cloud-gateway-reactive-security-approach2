package com.my.poc.springcloudgatewayreactivesecurityapproach2.security;

import com.my.poc.springcloudgatewayreactivesecurityapproach2.document.CustomDocumentServerAuthenticationConverter;
import com.my.poc.springcloudgatewayreactivesecurityapproach2.document.CustomDocumentServerAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    CustomReactiveAuthenticationManager customReactiveAuthenticationManager() {
        return new CustomReactiveAuthenticationManager();
    }

    @Bean
    CustomDocumentServerAuthenticationConverter customDocumentServerAuthenticationConverter() {
        return new CustomDocumentServerAuthenticationConverter();
    }

    @Bean
    CustomDocumentServerAuthenticationSuccessHandler customDocumentServerAuthenticationSuccessHandler() {
        return new CustomDocumentServerAuthenticationSuccessHandler();
    }
}
