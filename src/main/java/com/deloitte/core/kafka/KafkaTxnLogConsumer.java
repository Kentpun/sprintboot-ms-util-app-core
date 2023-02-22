package com.deloitte.core.kafka;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import com.deloitte.core.entity.EventHubKafkaConnConfigEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
/*
    This is a Kafka consumer template.
    Should be implemented directly in each service.
 */
@Configuration
@Scope("prototype")
@Slf4j
@Setter
@Getter
public class KafkaTxnLogConsumer {

    private EventHubKafkaConnConfigEntity entity;
    private ConcurrentKafkaListenerContainerFactory concurrentKafkaListenerContainerFactory;
    private String groupId;
    private BeanFactory beanFactory;

    public KafkaTxnLogConsumer(String groupId, EventHubKafkaConnConfigEntity entity, BeanFactory beanFactory){
        this.entity = entity;
        this.beanFactory = beanFactory;
        this.groupId = groupId;
        this.concurrentKafkaListenerContainerFactory = (ConcurrentKafkaListenerContainerFactory)
                beanFactory.getBean("txnLogKafkaListenerContainerFactory", this.groupId, this.entity);
    }
}
