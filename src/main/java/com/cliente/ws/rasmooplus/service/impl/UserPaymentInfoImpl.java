package com.cliente.ws.rasmooplus.service.impl;

import com.cliente.ws.rasmooplus.model.UserPaymentInfo;
import com.cliente.ws.rasmooplus.repository.UserPaymentInfoRepository;
import com.cliente.ws.rasmooplus.service.UserPaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserPaymentInfoImpl implements UserPaymentInfoService {

    @Autowired
    private UserPaymentInfoRepository userPaymentInfoRepository;

    @Override
    public List<UserPaymentInfo> findaAll() {
        return null;
    }

    @Override
    public UserPaymentInfo findaById(Long id) {
        return null;
    }

    @Override
    public UserPaymentInfo create(UserPaymentInfo userPaymentInfo) {
        return null;
    }

    @Override
    public UserPaymentInfo update(UserPaymentInfo userPaymentInfo) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
