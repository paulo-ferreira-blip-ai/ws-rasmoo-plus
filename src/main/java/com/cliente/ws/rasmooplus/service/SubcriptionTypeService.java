package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.dto.SubscriptionTypeDto;
import com.cliente.ws.rasmooplus.model.SubscriptionType;

import java.util.List;

public interface SubcriptionTypeService {

    List<SubscriptionType> findaAll();

    SubscriptionType findaById(Long id);

    SubscriptionType create(SubscriptionTypeDto subscriptionTypeDto);

    SubscriptionType update(Long id, SubscriptionTypeDto subscriptionTypeDto);

    void delete(Long id);


}
