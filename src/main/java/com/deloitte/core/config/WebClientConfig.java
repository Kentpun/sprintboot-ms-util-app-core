package com.deloitte.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
  @Value("${app.ext.payment-service.url:http://payment-service.default.svc.cluster.local:9000}")
  private String paymentServiceUrl;

  @Value("${app.ext.tokenization-service.url:http://tokenization-service.default.svc.cluster.local:9000}")
  private String tokenizationServiceUrl;
  
    @Bean(name = "payment-service")
    public WebClient paymentServiceWebClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl(paymentServiceUrl)
                .build();
        return webClient;
    }

    @Bean(name = "tokenization-service")
    public WebClient tokenizeServiceWebClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl(tokenizationServiceUrl)
                .build();
        return webClient;
    }
}
