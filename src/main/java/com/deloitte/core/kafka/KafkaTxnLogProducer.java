package com.deloitte.core.kafka;


import com.deloitte.core.config.KafkaProducerConfig;
import com.deloitte.core.entity.TxnLogEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

@Configuration
@Scope("prototype")
@Slf4j
@Setter
@Getter
public class KafkaTxnLogProducer {

    private String boostrapServerAddress;
    private KafkaTemplate<String, TxnLogEntity> kafkaTemplate;

    private BeanFactory beanFactory;

    public KafkaTxnLogProducer(String boostrapServerAddress, BeanFactory beanFactory){
        this.boostrapServerAddress = boostrapServerAddress;
        this.beanFactory = beanFactory;
        this.kafkaTemplate = (KafkaTemplate<String, TxnLogEntity>) beanFactory.getBean("txnLogKafkaTemplate", this.boostrapServerAddress);
    }

    public void send(String topic, TxnLogEntity payload) {
        log.info("sending payload='{}' to topic='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
    }
}
