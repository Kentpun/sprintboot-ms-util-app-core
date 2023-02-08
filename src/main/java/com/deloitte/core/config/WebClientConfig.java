package com.deloitte.core.config;

import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import com.deloitte.core.config.prop.AppApiProp;
import com.deloitte.core.config.prop.AppApiProp.ApiProp;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {
  private final AppApiProp appApiProp;
  
    @Bean(name = "payment-service")
    public WebClient paymentServiceWebClient() {
      String uri = Optional.ofNullable(appApiProp)
        .map(AppApiProp::getExt)
        .map(ext -> ext.get("payment-service"))
        .map(ApiProp::getUri)
        .orElse("http://payment-service.default.svc.cluster.local:9000");
      return WebClient.builder()
                .baseUrl(uri)
                .build();
    }

    @Bean(name = "tokenization-service")
    public WebClient tokenizeServiceWebClient() {
      String uri = Optional.ofNullable(appApiProp)
        .map(AppApiProp::getExt)
        .map(ext -> ext.get("tokenization-service"))
        .map(ApiProp::getUri)
        .orElse("http://tokenization-service.default.svc.cluster.local:9000");
      return WebClient.builder()
                .baseUrl(uri)
                .build();
    }
}
