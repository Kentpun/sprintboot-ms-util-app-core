package com.deloitte.core.config;

import com.deloitte.core.entity.EventHubKafkaConnConfigEntity;
import com.deloitte.core.entity.TxnLogEntity;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    @Scope("prototype")
    public ProducerFactory<String, String> producerFactory(String bootstrapServerAddress) {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, "20971520");

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    @Scope("prototype")
    public KafkaTemplate<String, String> kafkaTemplate(String bootstrapServerAddress) {
        return new KafkaTemplate<>(producerFactory(bootstrapServerAddress));
    }

    @Bean
    @Scope("prototype")
    public ProducerFactory<String, TxnLogEntity> txnLogProducerFactory(EventHubKafkaConnConfigEntity entity){
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, entity.getBootstrapServerAddress());
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configProps.put("sasl.mechanism", entity.getSaslMechanism());
        configProps.put("sasl.jaas.config", entity.getSaslJassConfig());
        configProps.put("security.protocol", entity.getSecurityProtocol());
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean(name = "txnLogKafkaTemplate")
    @Scope("prototype")
    public KafkaTemplate<String, TxnLogEntity> txnLogKafkaTemplate(EventHubKafkaConnConfigEntity entity){
        return new KafkaTemplate<>(txnLogProducerFactory(entity));
    }
}
