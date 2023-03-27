package com.cliente.ws.rasmooplus.service;

import com.cliente.ws.rasmooplus.model.User;

import java.util.List;

public interface UserService {
    List<User> findaAll();

    User findaById(Long id);

    User create(User user);

    User update(User user);

    void delete(Long id);
}
