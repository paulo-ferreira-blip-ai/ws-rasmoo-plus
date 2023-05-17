package com.cliente.ws.rasmooplus.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private String id;
    private String customerId;

    private String productAcronym;

    private BigDecimal discount;


}