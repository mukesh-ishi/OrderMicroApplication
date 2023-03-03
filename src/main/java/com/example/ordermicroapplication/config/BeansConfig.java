package com.example.ordermicroapplication.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.config.TopicBuilder;

public class BeansConfig {
    @Bean
    @Primary
    public NewTopic createNotification() {
        return TopicBuilder.name("Order_Notification").compact().build();

//.compact

    }
}
