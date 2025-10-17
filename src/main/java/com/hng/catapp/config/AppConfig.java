package com.hng.catapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class AppConfig {

    @Value("${catfact-api-timeout}")
    private int timeoutSeconds;

    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(timeoutSeconds * 1000);
        factory.setReadTimeout(timeoutSeconds * 1000);

        return new RestTemplate(factory);
    }

}
