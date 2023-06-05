package com.cliente.ws.rasmooplus.mapper.wsraspay;

import com.cliente.ws.rasmooplus.dto.wsraspay.CreditCardDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.PaymentDto;

public class PaymentMapper {

    public static PaymentDto build(String customerId, String orderId, CreditCardDto dto) {
        return PaymentDto.builder()
                .creditCard(dto)
                .customerId(customerId)
                .orderId(orderId)
                .build();
    }
}
