package com.deloitte.core.kafka;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.core.KafkaTemplate;
import com.deloitte.core.entity.EventHubKafkaConnConfigEntity;
import com.deloitte.core.entity.TxnLogEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Scope("prototype")
@Slf4j
@Setter
@Getter
public class KafkaTxnLogProducer {

    private EventHubKafkaConnConfigEntity entity;
    private KafkaTemplate<String, TxnLogEntity> kafkaTemplate;

    private BeanFactory beanFactory;

    public KafkaTxnLogProducer(EventHubKafkaConnConfigEntity entity, BeanFactory beanFactory){
        this.entity = entity;
        this.beanFactory = beanFactory;
        this.kafkaTemplate = (KafkaTemplate<String, TxnLogEntity>) beanFactory.getBean("txnLogKafkaTemplate", this.entity);
    }

    public void send(String topic, TxnLogEntity payload) {
        log.info("sending payload='{}' to topic='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
    }
}
