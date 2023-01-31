package com.deloitte.core.kafka;


import com.deloitte.core.config.KafkaProducerConfig;
import com.deloitte.core.entity.TxnLogEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class KafkaTxnLogProducer {

    private KafkaTemplate<String, TxnLogEntity> kafkaTemplate;
    private Map<String, Object> producerConfigs = new HashMap<>();

    public KafkaTxnLogProducer(String boostrapServerAddress){
        this.producerConfigs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                boostrapServerAddress);
        this.producerConfigs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        this.producerConfigs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        this.kafkaTemplate = new KafkaTemplate<String, TxnLogEntity>(new DefaultKafkaProducerFactory<>(producerConfigs));
    }

    public void send(String topic, TxnLogEntity payload) {
        log.info("sending payload='{}' to topic='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
    }
}
