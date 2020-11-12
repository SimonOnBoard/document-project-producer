package com.itis.javalab.student.documents.system.config;

import com.rabbitmq.client.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;

@Configuration
@RequiredArgsConstructor
public class ApplicationContext {
    private final Environment environment;

    @Bean
    public String directExchangeName(){
        return environment.getProperty("exchange.name.direct");
    }

    @Bean
    public String directExchangeType(){
        return environment.getProperty("exchange.type.direct");
    }

    @Bean
    public String topicExchangeName(){
        return environment.getProperty("exchange.name.topic");
    }

    @Bean
    public String topicExchangeType(){
        return environment.getProperty("exchange.type.topic");
    }

    @Bean
    public String teachersQueueName(){
        return environment.getProperty("teachers.queue.name");
    }

    @Bean
    public String studentsQueueName(){
        return environment.getProperty("students.queue.name");
    }

    @Bean
    public String teachersQueueKey(){
        return environment.getProperty("teachers.queue.key");
    }

    @Bean
    public String studentsQueueKey(){
        return environment.getProperty("students.queue.key");
    }

    @Bean
    public String teachersTopicKey(){
        return environment.getProperty("teachers.queue.topic.key");
    }

    @Bean
    public String studentsTopicKey(){
        return environment.getProperty("students.queue.topic.key");
    }



    @Bean
    public ConnectionFactory connectionFactory(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        return connectionFactory;
    }
}
