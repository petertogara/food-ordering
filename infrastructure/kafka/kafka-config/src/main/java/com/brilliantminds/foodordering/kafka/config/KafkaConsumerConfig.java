package com.brilliantminds.foodordering.kafka.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "kafka-consumer-config")
public class KafkaConsumerConfig {

    private String keyDeserializer;
    private String valueDeserializer;
    private String autoOffsetReset;
    private String specificAvroReaderKey;
    private String specificAvroReader;
    private Boolean batchListener;
    private Boolean autoStartup;
    private Integer concurrencyLevel;
    private Integer sessionTimeoutMs;
    private Integer heartBeatIntervalMs;
    private Integer maxPollingIntervalMs;
    private Long pollTimeoutMs;
    private Integer maxPollRecords;
    private Integer maxPartitionFetchBytesDefault;
    private Integer maxPartitionFetchBytesBoostFactor;
}
