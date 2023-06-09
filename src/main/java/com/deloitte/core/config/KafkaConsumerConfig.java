package com.deloitte.core.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import com.deloitte.core.entity.EventHubKafkaConnConfigEntity;
import com.deloitte.core.entity.TxnLogEntity;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    public ConsumerFactory<String, String> consumerFactory(String groupId, String bootstrapServerAddress) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, "20971520");
        props.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, "20971520");
        return new DefaultKafkaConsumerFactory<>(props);
    }

    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(String groupId, String bootstrapServerAddress) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(groupId, bootstrapServerAddress));
        return factory;
    }

    public ConsumerFactory<String, TxnLogEntity> txnLogConsumerFactory(String groupId, EventHubKafkaConnConfigEntity entity) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, entity.getBootstrapServerAddress());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put("sasl.mechanism", entity.getSaslMechanism());
        props.put("sasl.jaas.config", entity.getSaslJassConfig());
        props.put("security.protocol", entity.getSecurityProtocol());
        return new DefaultKafkaConsumerFactory<>(props,
                new StringDeserializer(),
                new JsonDeserializer<>(TxnLogEntity.class));
    }

    @Bean(name = "txnLogKafkaListenerContainerFactory")
//    @Scope("prototype")
    public ConcurrentKafkaListenerContainerFactory<String, TxnLogEntity> txnLogKafkaListenerContainerFactory(String groupId, EventHubKafkaConnConfigEntity entity) {

        ConcurrentKafkaListenerContainerFactory<String, TxnLogEntity> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(txnLogConsumerFactory(groupId, entity));
        return factory;
    }

}
