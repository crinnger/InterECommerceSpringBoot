package br.com.crinnger.interbootcamp.ecommerce.checkout.service;

import br.com.crinnger.interbootcamp.ecommerce.checkout.entity.CheckoutEntity;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import br.com.crinnger.interbootcamp.ecommerce.checkout.event.CheckoutCreatedEvent;

/**@Service
@CommonsLog(topic = "Cosumer Logger")
public class Consumer {
    @Value("${topic.name}")
    private String topic;

    @KafkaListener(topics = "paid", groupId = "checkout")
    public void consume(ConsumerRecord<String, CheckoutCreatedEvent> record) {
        log.info(String.format("Consumed message -> %s", record.value()));
    }
}
*/