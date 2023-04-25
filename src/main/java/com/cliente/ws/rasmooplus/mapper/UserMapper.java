package com.cliente.ws.rasmooplus.mapper;

import com.cliente.ws.rasmooplus.dto.UserDto;
import com.cliente.ws.rasmooplus.model.SubscriptionType;
import com.cliente.ws.rasmooplus.model.User;
import com.cliente.ws.rasmooplus.model.UserType;

public class UserMapper {
    public static User fromDtoToEntity(UserDto userDto, UserType userType, SubscriptionType subscriptionType) {
        return User.builder()
                .cpf(userDto.getCpf())
                .phone(userDto.getPhone())
                .dtExpiration(userDto.getDtExpiration())
                .email(userDto.getEmail())
                .name(userDto.getName())
                .id(userDto.getId())
                .dtSubscription(userDto.getDtSubscription())
                .userType(userType)
                .subscriptionType(subscriptionType)
                .build();

    }
}
