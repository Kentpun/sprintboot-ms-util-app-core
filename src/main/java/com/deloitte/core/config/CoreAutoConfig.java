package com.deloitte.core.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.deloitte.core.config.prop.AppApiProp;

@Configuration(proxyBeanMethods = false)
@Import({//
    WebClientConfig.class//
})
@EnableConfigurationProperties(AppApiProp.class)
public class CoreAutoConfig {

}
