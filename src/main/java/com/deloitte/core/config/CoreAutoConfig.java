package com.deloitte.core.config;

import com.deloitte.core.redis.CdeIdRepository;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.deloitte.core.config.prop.AppApiProp;

@Configuration(proxyBeanMethods = false)
@Import({//
    WebClientConfig.class, CdeIdLibraryConfig.class
})
@EnableConfigurationProperties(AppApiProp.class)
public class CoreAutoConfig {

}
