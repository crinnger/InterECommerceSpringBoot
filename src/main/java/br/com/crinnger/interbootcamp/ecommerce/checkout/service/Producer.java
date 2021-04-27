package br.com.crinnger.interbootcamp.ecommerce.checkout.service;

import br.com.crinnger.interbootcamp.ecommerce.checkout.entity.CheckoutEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import br.com.crinnger.interbootcamp.ecommerce.checkout.event.CheckoutCreatedEvent;

/**@Service
@CommonsLog(topic = "Producer Logger")
@RequiredArgsConstructor
public class Producer {

    @Value("${topic.name}")
    private String topic;

    private final KafkaTemplate<String, CheckoutCreatedEvent> kafkaTemplate;

    void sendMessage(CheckoutCreatedEvent checkoutCreatedEvent) {
        this.kafkaTemplate.send(this.topic,checkoutCreatedEvent);
        log.info(String.format("Produced user -> %s", checkoutCreatedEvent.toString()));
    }
}
*/