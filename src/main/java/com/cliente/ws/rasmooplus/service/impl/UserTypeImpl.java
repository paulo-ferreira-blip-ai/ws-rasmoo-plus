package com.cliente.ws.rasmooplus.service.impl;

import com.cliente.ws.rasmooplus.model.UserType;
import com.cliente.ws.rasmooplus.repository.UserTypeRepository;
import com.cliente.ws.rasmooplus.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserTypeImpl implements UserTypeService {
    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public List<UserType> findaAll() {
        return null;
    }

    @Override
    public UserType findaById(Long id) {
        return null;
    }

    @Override
    public UserType create(UserType userType) {
        return null;
    }

    @Override
    public UserType update(UserType userType) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
