package com.cliente.ws.rasmooplus.service.impl;

import com.cliente.ws.rasmooplus.model.User;
import com.cliente.ws.rasmooplus.repository.UserRepository;
import com.cliente.ws.rasmooplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findaAll() {
        return null;
    }

    @Override
    public User findaById(Long id) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
