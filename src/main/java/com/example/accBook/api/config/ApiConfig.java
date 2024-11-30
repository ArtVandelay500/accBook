package com.example.accBook.api.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties(prefix = "api.config")
public class ApiConfig {
    @Value("${api.config.client-id}")
    private String client_id;

    @Value("${api.config.client-secret}")
    private String client_secret;

    @Value("${api.config.client-code}")
    private String client_code;
}

