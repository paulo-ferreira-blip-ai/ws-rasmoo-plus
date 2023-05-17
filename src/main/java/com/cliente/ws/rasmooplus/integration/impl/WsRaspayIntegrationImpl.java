package com.cliente.ws.rasmooplus.integration.impl;

import com.cliente.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.PaymentDto;
import com.cliente.ws.rasmooplus.integration.WsRaspayIntegration;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

    @Value("${RASPAY_HOST:http://localhost:8081/ws-raspay}")
    private String raspayHost;
    @Value("${RASPAY_CUSTOMER:/v1/customer}")
    private String raspayCustomer;
    @Value("${RASPAY_ORDER:/v1/order}")
    private String raspayOrder;
    @Value("${RASPAY_PAYMENT:/v1/payment/credit-card/}")
    private String raspayPayment;


    private final RestTemplate restTemplate;
    private final HttpHeaders headers;

    public WsRaspayIntegrationImpl() {
        restTemplate = new RestTemplate();
        headers = getHttpHeaders();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        try {
            HttpEntity<CustomerDto> request = new HttpEntity<>(customerDto, this.headers);
            ResponseEntity<CustomerDto> response =
                    restTemplate.exchange(raspayHost + raspayCustomer, HttpMethod.POST, request, CustomerDto.class);
            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        try {
            HttpEntity<OrderDto> request = new HttpEntity<>(orderDto, this.headers);
            ResponseEntity<OrderDto> response =
                    restTemplate.exchange(raspayHost + raspayOrder, HttpMethod.POST, request, OrderDto.class);
            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public Boolean processPayment(PaymentDto paymentDto) {
        try {
            HttpEntity<PaymentDto> request = new HttpEntity<>(paymentDto, this.headers);
            ResponseEntity<Boolean> response =
                    restTemplate.exchange(raspayHost + raspayPayment, HttpMethod.POST, request, Boolean.class);
            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }

    public static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String credential = "rasmooplus:r@sm00";
        String base64 = new String(Base64.encodeBase64(credential.getBytes()));
        headers.add("Authorization", "Basic " + base64);
        return headers;
    }
}
