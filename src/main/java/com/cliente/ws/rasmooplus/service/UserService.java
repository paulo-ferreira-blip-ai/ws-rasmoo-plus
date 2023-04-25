package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.dto.UserDto;
import com.cliente.ws.rasmooplus.model.User;

import java.util.List;

public interface UserService {
    List<User> findaAll();

    User findaById(Long id);

    User create(UserDto userDto);

    User update(User user);

    void delete(Long id);
}
