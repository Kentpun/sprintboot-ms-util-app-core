package com.deloitte.core.config;

import com.deloitte.core.redis.CdeIdRepository;
import com.deloitte.core.utils.CdeIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import(RedisClientConfig.class)
@EntityScan("com.deloitte.core.entity.CdeId")
@EnableJpaRepositories("com.deloitte.core.redis.CdeIdRepository")
public class CdeIdLibraryConfig {

    @Bean(name = "cdeIdLibrary")
    public CdeIdUtil cdeIdUtil(){
        return new CdeIdUtil();
    }
}
