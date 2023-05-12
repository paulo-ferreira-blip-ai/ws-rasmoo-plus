package com.cliente.ws.rasmooplus.integration;

import com.cliente.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.OrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class WsRaspayIntegrationImplTest {
    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;


    @Test
    void createCustomerQuandoDtoOk(){
        CustomerDto dto = new CustomerDto(null,"Paulo","Renan","paulorenan1515@gmail.com","02094884252");
        wsRaspayIntegration.createCustomer(dto);

    }

    @Test
    void createOrderQuandoDtoOk(){
        OrderDto dto = new OrderDto(null,"","",BigDecimal.ZERO);
        wsRaspayIntegration.createOrder(dto);

    }


}
