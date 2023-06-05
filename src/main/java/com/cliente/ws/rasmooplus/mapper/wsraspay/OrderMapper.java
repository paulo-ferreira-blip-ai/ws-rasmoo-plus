package com.cliente.ws.rasmooplus.mapper.wsraspay;

import com.cliente.ws.rasmooplus.dto.PaymentProcessDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.OrderDto;

public class OrderMapper {

    public static OrderDto build(String customerId, PaymentProcessDto paymentProcessDto) {

        return OrderDto.builder()
                .customerId(customerId)
                .productAcronym(paymentProcessDto.getProductKey())
                .discount(paymentProcessDto.getDiscount())
                .build();
    }
}
