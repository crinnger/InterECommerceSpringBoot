package br.com.crinnger.interbootcamp.ecommerce.checkout.listener;

import br.com.crinnger.interbootcamp.ecommerce.checkout.entity.CheckoutEntity;
import br.com.crinnger.interbootcamp.ecommerce.checkout.repository.CheckoutRepository;
import br.com.crinnger.interbootcamp.ecommerce.checkout.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import br.com.crinnger.interbootcamp.ecommerce.checkout.event.PaymentCreatedEvent;

@Component
public class PaymentPaidListener {

    private CheckoutRepository checkoutRepository;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent event){
        CheckoutEntity checkoutEntity= checkoutRepository.findByCode(event.getCheckoutCode()).orElseThrow();
        checkoutEntity.setStatus(CheckoutEntity.Status.APPROVED);
        checkoutRepository.save(checkoutEntity);
    }
}
