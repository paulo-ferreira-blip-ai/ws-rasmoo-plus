package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.model.UserPaymentInfo;

import java.util.List;

public interface UserPaymentInfoService {

    List<UserPaymentInfo> findaAll();

    UserPaymentInfo findaById(Long id);

    UserPaymentInfo create(UserPaymentInfo userPaymentInfo);

    UserPaymentInfo update(UserPaymentInfo userPaymentInfo);

    void delete(Long id);
}
