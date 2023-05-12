package com.cliente.ws.rasmooplus.integration.impl;

import com.cliente.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.PaymentDto;
import com.cliente.ws.rasmooplus.integration.WsRaspayIntegration;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {
    private RestTemplate restTemplate;
    private final HttpHeaders headers;

    public WsRaspayIntegrationImpl() {
        restTemplate = new RestTemplate();
        headers = getHttpHeaders();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        try {


            HttpEntity<CustomerDto> request = new HttpEntity<>(customerDto,this.headers);
            ResponseEntity<CustomerDto> response =
                    restTemplate.exchange("http://localhost:8081/ws-raspay/v1/customer", HttpMethod.POST, request, CustomerDto.class);
            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        try {
            HttpEntity<OrderDto> request = new HttpEntity<>(orderDto,this.headers);
            ResponseEntity<OrderDto> response =
                    restTemplate.exchange("http://localhost:8081/ws-raspay/v1/order", HttpMethod.POST, request, OrderDto.class);
            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Boolean processPayment(PaymentDto paymentDto) {
        return null;
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String credential = "rasmooplus:r@sm00";
        String base64 = new String(Base64.encodeBase64(credential.getBytes()));
        headers.add("Authorization", "Basic " + base64);//o espaço após Basic é essencial para funcionar a atorização
        return headers;
    }
}
