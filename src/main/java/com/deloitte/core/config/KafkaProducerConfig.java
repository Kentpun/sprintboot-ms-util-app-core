package com.deloitte.core.config;

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

//    @Bean
//    public ProducerFactory<String, String> producerFactory(String bootstrapServerAddress) {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerAddress);
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, "20971520");
//
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate(String bootstrapServerAddress) {
//        return new KafkaTemplate<>(producerFactory(bootstrapServerAddress));
//    }
//    @Bean(name = "ProducerConfigs")
//    public Map<String, Object> producerConfigs() {
//        Map<String, Object> props = new HashMap<>();
////        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
////                bootstrapServers);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
//                StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//                StringSerializer.class);
//        return props;
//    }

//    @Bean(name = "ProducerFactory")
//    public ProducerFactory<String, String> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//    @Bean
//    public ProducerFactory<String, TxnLogEntity> txnLogProducerFactory(String bootstrapServerAddress){
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerAddress);
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }

//    @Bean(name = "TxnLogKafkaTemplate")
////    @Scope("prototype")
//    public KafkaTemplate<String, TxnLogEntity> txnLogKafkaTemplate(String bootstrapServerAddress){
//        return new KafkaTemplate<>(txnLogProducerFactory(bootstrapServerAddress));
//    }
}
