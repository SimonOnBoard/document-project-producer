package com.itis.javalab.student.documents.system.services.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itis.javalab.student.documents.system.models.PersonWithMail;
import com.itis.javalab.student.documents.system.services.interfaces.ExchangeSender;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeoutException;


@Service
@RequiredArgsConstructor
public class ExchangeSenderTopicImpl implements ExchangeSender {
    private final ConnectionFactory connectionFactory;
    private final String topicExchangeName;
    private final String topicExchangeType;
    private final ObjectMapper objectMapper;
    private Connection connection;

    @PostConstruct
    public void setNewConnection() {
        try {
            connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(topicExchangeName, topicExchangeType);
        } catch (IOException | TimeoutException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void sendMessages(String key, PersonWithMail person) {
        try (Channel channel = connection.createChannel()) {
            channel.basicPublish(topicExchangeName, key,
                    null, objectMapper.writeValueAsBytes(person));
        } catch (IOException | TimeoutException e) {
            throw new IllegalStateException(e);
        }
    }
}
