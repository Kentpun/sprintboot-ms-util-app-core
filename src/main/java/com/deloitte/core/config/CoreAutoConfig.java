package com.deloitte.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import lombok.RequiredArgsConstructor;

@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
@Import({//
    WebClientConfig.class//
})
public class CoreAutoConfig {

}
