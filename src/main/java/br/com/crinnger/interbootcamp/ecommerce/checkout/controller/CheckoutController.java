package br.com.crinnger.interbootcamp.ecommerce.checkout.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/checkout")
public class CheckoutController {
	
	private final CheckoutCreatedSource checkoutCreatedSource;

}
