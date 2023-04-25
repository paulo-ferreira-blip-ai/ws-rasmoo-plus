package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.dto.UserTypeDto;
import com.cliente.ws.rasmooplus.model.UserType;

import java.util.List;

public interface UserTypeService {
    List<UserType> findAll();

    UserType findById(Long id);

    UserType create(UserTypeDto userTypeDto);

    UserType update(UserType userType);

    void delete(Long id);
}
