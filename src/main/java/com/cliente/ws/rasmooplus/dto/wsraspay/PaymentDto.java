package com.cliente.ws.rasmooplus.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private String customerId;

    private String orderId;

    private CreditCardDto creditCard;
}
