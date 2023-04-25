package com.cliente.ws.rasmooplus.service.impl;

import com.cliente.ws.rasmooplus.dto.UserTypeDto;
import com.cliente.ws.rasmooplus.exception.BadRequestException;
import com.cliente.ws.rasmooplus.mapper.UserTypeMapper;
import com.cliente.ws.rasmooplus.model.UserType;
import com.cliente.ws.rasmooplus.repository.UserTypeRepository;
import com.cliente.ws.rasmooplus.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class UserTypeImpl implements UserTypeService {
    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public List<UserType> findAll() {
        return userTypeRepository.findAll();
    }

    @Override
    public UserType findById(Long id) {
        return null;
    }

    @Override
    public UserType create(UserTypeDto userTypeDto) {
        if (Objects.nonNull(userTypeDto.getId())){
            throw new BadRequestException("Id deve ser nulo");
        }

        UserType userType = UserTypeMapper.fromDtoToEntity(userTypeDto);
        return userTypeRepository.save(userType);
    }

    @Override
    public UserType update(UserType userType) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
