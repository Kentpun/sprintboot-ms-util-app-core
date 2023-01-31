package com.deloitte.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean(name = "payment-service")
    public WebClient paymentServiceWebClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://tokenization-service.default.svc.cluster.local:9000")
                .build();
        return webClient;
    }

    @Bean(name = "tokenize-service")
    public WebClient tokenizeServiceWebClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://payment-service.default.svc.cluster.local:9000")
                .build();
        return webClient;
    }
}
