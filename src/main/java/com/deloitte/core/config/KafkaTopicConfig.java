//package com.deloitte.core.config;
//
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.KafkaAdmin;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaTopicConfig {
//
//    @Value("${kafka.bootstrapEndpoint}")
//    private String bootstrapAddress;
//
//    @Value("${kafka.sharedAccessKeyName")
//    private String bootstrapAccessKeyName;
//
//    @Value("${kafka.sharedAccessKey")
//    private String bootstrapAccessKey;
//
//    @Value(value = "${message.topic.name}")
//    private String topicName;
//
//    @Bean
//    public KafkaAdmin kafkaAdmin(){
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "bootstrapAddress");
//        return new KafkaAdmin(configs);
//    }
//
////    @Bean
////    public NewTopic newTopic(){
////        return new NewTopic(topicName, 1, (short) 2);
////    }
//
//}
