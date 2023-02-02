package com.deloitte.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EventHubKafkaConnConfigEntity {
    private final String saslMechanism;
    private final String saslJassConfig;
    private final String securityProtocol;
    private final String bootstrapServerAddress;
}
