package com.deloitte.core.kafka;


import com.deloitte.core.config.KafkaProducerConfig;
import com.deloitte.core.entity.TxnLogEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class KafkaTxnLogProducer {

    @Autowired
    @Qualifier("TxnLogKafkaTemplate")
    private KafkaTemplate<String, TxnLogEntity> kafkaTemplate;

    public void send(String topic, TxnLogEntity payload) {
        log.info("sending payload='{}' to topic='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
    }
}
