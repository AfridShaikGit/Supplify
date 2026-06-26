package com.example.supplify.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class KafkaTopicConfig {

    @Bean
    public NewTopic orderTopic() {

        return new NewTopic(
                "order-topic",
                1,
                (short) 1
        );
    }
}