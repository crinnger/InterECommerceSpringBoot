package br.com.crinnger.interbootcamp.ecommerce.checkout.service;

import br.com.crinnger.interbootcamp.ecommerce.checkout.entity.CheckoutEntity;
import br.com.crinnger.interbootcamp.ecommerce.checkout.model.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {
    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
    Optional<CheckoutEntity> findById(Long id);
}
