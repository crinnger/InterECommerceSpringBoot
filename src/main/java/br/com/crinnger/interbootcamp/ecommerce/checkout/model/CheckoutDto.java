package br.com.crinnger.interbootcamp.ecommerce.checkout.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckoutDto implements Serializable{	
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String address;
	private String complement;
	private String country;
	private String state;
	private String cep;
	private Boolean saveAddress;
	private Boolean saveInfo;
	private String paymentMethod;
	private String cardName;
	private String cardNumber;
	private String cardDate;
	private String cardCvv;
}
