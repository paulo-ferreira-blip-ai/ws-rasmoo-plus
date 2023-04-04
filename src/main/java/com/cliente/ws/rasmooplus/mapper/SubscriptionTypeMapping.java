package com.cliente.ws.rasmooplus.mapper;

import com.cliente.ws.rasmooplus.dto.SubscriptionTypeDto;
import com.cliente.ws.rasmooplus.model.SubscriptionType;

public class SubscriptionTypeMapping {

    public static SubscriptionType fromDtoToEntity(SubscriptionTypeDto subscriptionTypeDto){
        return SubscriptionType.builder() //método que faz mapeamento da classe dto para Model, isso por usar a anotação @Builde na classe
                .id(subscriptionTypeDto.getId())
                .name(subscriptionTypeDto.getName())
                .accessMonths(subscriptionTypeDto.getAccessMonths())
                .price(subscriptionTypeDto.getPrice())
                .productKey(subscriptionTypeDto.getProductKey())
                .build();
    }
}
