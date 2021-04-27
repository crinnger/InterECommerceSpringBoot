package br.com.crinnger.interbootcamp.ecommerce.checkout.service;


import br.com.crinnger.interbootcamp.ecommerce.checkout.entity.CheckoutEntity;
import br.com.crinnger.interbootcamp.ecommerce.checkout.event.CheckoutCreatedEvent;
import br.com.crinnger.interbootcamp.ecommerce.checkout.model.CheckoutRequest;
import br.com.crinnger.interbootcamp.ecommerce.checkout.repository.CheckoutRepository;
import br.com.crinnger.interbootcamp.ecommerce.checkout.streaming.CheckoutCreatedSource;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;
    //private final Producer producer;
    private final CheckoutCreatedSource checkoutCreatedSource;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .status(CheckoutEntity.Status.CREATED)
                .build();
        CheckoutEntity checkoutEntitySave = checkoutRepository.save(checkoutEntity);

        CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(checkoutEntitySave.getCode())
                .setStatus(checkoutEntitySave.getStatus().name())
                .build();
        checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());
//      this.producer.sendMessage(checkoutCreatedEvent);
        return Optional.of(checkoutEntitySave);
    }

    @Override
    public Optional<CheckoutEntity> findById(Long id) {
        return checkoutRepository.findById(id);
    }
}
