package com.cliente.ws.rasmooplus.service.impl;

import com.cliente.ws.rasmooplus.dto.UserDto;
import com.cliente.ws.rasmooplus.exception.BadRequestException;
import com.cliente.ws.rasmooplus.exception.NotFoundException;
import com.cliente.ws.rasmooplus.mapper.UserMapper;
import com.cliente.ws.rasmooplus.model.User;
import com.cliente.ws.rasmooplus.model.UserType;
import com.cliente.ws.rasmooplus.repository.UserRepository;
import com.cliente.ws.rasmooplus.repository.UserTypeRepository;
import com.cliente.ws.rasmooplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public List<User> findaAll() {
        return null;
    }

    @Override
    public User findaById(Long id) {
        return null;
    }

    @Override
    public User create(UserDto userDto) {
        if (Objects.nonNull(userDto.getId())) {
            throw new BadRequestException(" id deve ser nulo");
        }

        var userTypeOpt = userTypeRepository.findById(userDto.getUserTypeId());// Opt = optional

        if (userTypeOpt.isEmpty()) {
            throw new NotFoundException(" userTypeid não encontrado");
        }

        UserType userType = userTypeOpt.get();
        User user = UserMapper.fromDtoToEntity(userDto, userType, null);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
