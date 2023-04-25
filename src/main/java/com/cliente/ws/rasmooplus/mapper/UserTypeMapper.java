package com.cliente.ws.rasmooplus.mapper;

import com.cliente.ws.rasmooplus.dto.UserTypeDto;
import com.cliente.ws.rasmooplus.model.UserType;

public class UserTypeMapper {
    public static UserType fromDtoToEntity (UserTypeDto userTypeDto){
        return UserType.builder()
                .name(userTypeDto.getName())
                .description(userTypeDto.getDescription())
                .id(userTypeDto.getId())
                .build();
    }
}
