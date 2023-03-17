package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.model.SubscriptionType;

import java.util.List;

public interface SubcriptionTypeService {

    List<SubscriptionType> findaAll();

    SubscriptionType findaById(Long id);

    SubscriptionType create(SubscriptionType subscriptionType);

    SubscriptionType update(SubscriptionType subscriptionType);

    void delete(Long id);


}
