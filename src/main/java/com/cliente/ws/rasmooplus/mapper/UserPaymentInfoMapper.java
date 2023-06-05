package com.cliente.ws.rasmooplus.mapper;

import com.cliente.ws.rasmooplus.dto.UserPaymentInfoDto;
import com.cliente.ws.rasmooplus.model.User;
import com.cliente.ws.rasmooplus.model.UserPaymentInfo;

public class UserPaymentInfoMapper {

    public static UserPaymentInfo fromDtoToEntity(UserPaymentInfoDto dto, User user) {
        return UserPaymentInfo.builder()
                .id(dto.getId())
                .user(user)
                .dtPayment(dto.getDtPayment())
                .cardNumber(dto.getCardNumber())
                .cardSecurityCode(dto.getCardSecurityCode())
                .expirationMonth(dto.getExpirationMonth())
                .price(dto.getPrice())
                .expirationYear(dto.getExpirationYear())
                .installments(dto.getInstallments())
                .build();

    }

}
