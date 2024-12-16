package com.robert.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApiConfig {

    @Value("${api.url}")
    private String API_URL;

    @Bean
    public WebClient webClient(){
        return WebClient.builder().baseUrl(API_URL).build();
    }
}
