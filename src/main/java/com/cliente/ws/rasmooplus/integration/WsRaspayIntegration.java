package com.cliente.ws.rasmooplus.integration;

import com.cliente.ws.rasmooplus.dto.wsraspay.*;

public interface WsRaspayIntegration {
    CustomerDto createCustomer(CustomerDto customerDto);

    OrderDto createOrder(OrderDto orderDto);

    Boolean processPayment(PaymentDto paymentDto);
}
