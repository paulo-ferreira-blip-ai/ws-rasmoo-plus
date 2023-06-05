package com.cliente.ws.rasmooplus.mapper.wsraspay;

import com.cliente.ws.rasmooplus.dto.UserPaymentInfoDto;
import com.cliente.ws.rasmooplus.dto.wsraspay.CreditCardDto;

public class CreditCardMapper {

    public static CreditCardDto build(UserPaymentInfoDto dto, String documentNumber) {
        return CreditCardDto.builder()
                .cvv(Long.parseLong(dto.getCardSecurityCode()))
                .month(dto.getExpirationMonth())
                .documentNumber(documentNumber)
                .year(dto.getExpirationYear())
                .number(dto.getCardNumber())
                .installments(dto.getInstallments())
                .build();
    }

}
