package com.deloitte.core.config;

import com.deloitte.core.entity.CdeId;
import com.deloitte.core.utils.CdeIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@Configuration
@Import({RedisClientConfig.class, CdeIdUtil.class})
public class CdeIdLibraryConfig {

    @Bean
    @ConditionalOnClass(CrudRepository.class)
    public CdeIdUtil cdeIdUtil(CrudRepository<CdeId, String> repository) {
        return new CdeIdUtil(repository);
    }
}
