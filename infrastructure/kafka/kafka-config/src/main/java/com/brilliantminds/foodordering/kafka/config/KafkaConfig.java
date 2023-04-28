package com.brilliantminds.foodordering.kafka.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "kafka-config")
public class KafkaConfig {

    private String bootstrapservers;
    private String schemaRegistryUrlKey;
    private String schemaRegistryUrl;
    private String numOfPartitions;
    private String replicationFactor;
}
