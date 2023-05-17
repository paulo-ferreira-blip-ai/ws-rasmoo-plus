package com.cliente.ws.rasmooplus.integration;

import com.cliente.ws.rasmooplus.dto.wsraspay.CreditCardDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.PaymentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class WsRaspayIntegrationImplTest {
    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;


    @Test
    void createCustomerQuandoDtoOk() {
        CustomerDto dto = new CustomerDto(null, "Cicera", "Alves", "paulorenan13@gmail.com", "33161694074");
        wsRaspayIntegration.createCustomer(dto);
    }

    @Test
    void createOrderQuandoDtoOk() {
        OrderDto dto = new OrderDto(null, "646508c2753c270d85ad0e87", "MONTH22", BigDecimal.ZERO);
        wsRaspayIntegration.createOrder(dto);
    }

    @Test
    void processPaymentQuandoDtoOk() {
        CreditCardDto credCardDto = new CreditCardDto("1234567812345678", 123L, 6L, 2025L, "17723352077", 0L);
        PaymentDto paymentDto = new PaymentDto("646508c2753c270d85ad0e87", "6465126f753c270d85ad0e89", credCardDto);
        wsRaspayIntegration.processPayment(paymentDto);
    }

}
