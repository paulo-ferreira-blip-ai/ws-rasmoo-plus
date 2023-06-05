package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.dto.PaymentProcessDto;

public interface PaymentInfoService {

    Boolean process(PaymentProcessDto dto);
}
