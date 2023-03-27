package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.model.UserType;

import java.util.List;

public interface UserTypeService {
    List<UserType> findaAll();

    UserType findaById(Long id);

    UserType create(UserType userType);

    UserType update(UserType userType);

    void delete(Long id);
}
