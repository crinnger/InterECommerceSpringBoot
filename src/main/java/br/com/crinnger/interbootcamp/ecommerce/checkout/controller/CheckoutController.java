package br.com.crinnger.interbootcamp.ecommerce.checkout.controller;

import br.com.crinnger.interbootcamp.ecommerce.checkout.entity.CheckoutEntity;
import br.com.crinnger.interbootcamp.ecommerce.checkout.model.CheckoutRequest;
import br.com.crinnger.interbootcamp.ecommerce.checkout.model.CheckoutResponse;
import br.com.crinnger.interbootcamp.ecommerce.checkout.service.CheckoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutController {
	
	private final CheckoutService checkoutService;

/**	@PostMapping("/")
	public ResponseEntity<CheckoutResponse> create(CheckoutRequest checkoutRequest){
		CheckoutEntity checkoutEntity=checkoutService.create(checkoutRequest).orElseThrow();
		CheckoutResponse checkoutResponse = CheckoutResponse.builder()
				.id(checkoutEntity.getId())
				.build();
		return ResponseEntity.status(HttpStatus.CREATED).body(checkoutResponse);
	}*/

	@PostMapping("/")
	public ResponseEntity<CheckoutResponse> create(CheckoutRequest checkoutRequest){
		CheckoutEntity checkoutEntity=checkoutService.create(checkoutRequest).orElseThrow();
		CheckoutResponse checkoutResponse = CheckoutResponse.builder()
			.id(checkoutEntity.getId())
			.build();
		return ResponseEntity.status(HttpStatus.CREATED).body(checkoutResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CheckoutEntity>  getById(@NotNull @PathVariable Long id){
		CheckoutEntity checkoutEntity=checkoutService.findById(id).orElseThrow();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(checkoutEntity);
	}

}
