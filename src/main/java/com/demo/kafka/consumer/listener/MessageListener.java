package com.demo.kafka.consumer.listener;

import com.demo.kafka.model.Greeting;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "test", groupId = "foo")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }

    @KafkaListener(topics = "test.second")
    public void listenWithHeaders(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition
    ){
        System.out.println("Received Message: " + message + " from partition: " + partition);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "partition", partitions = { "0", "1" }), groupId = "group.1")
    public void listenToPartition(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition
    ){
        System.out.println("Received Message: " + message + " from partition: " + partition);
    }

    @KafkaListener(
            topics = "baeldung",
            containerFactory = "filterKafkaListenerContainerFactory"
    )
    public void listenWithFilter(String message) {
        System.out.println("Received Message in filtered listener: " + message);
    }

    @KafkaListener(
            topics = "greeting",
            containerFactory = "greetingKafkaListenerContainerFactory")
    public void greetingListener(Greeting greeting) {
        System.out.println("Received Message: " + greeting.getMsg() + " of name: " + greeting.getName());
    }
}
