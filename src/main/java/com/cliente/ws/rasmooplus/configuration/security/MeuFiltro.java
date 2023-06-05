package com.cliente.ws.rasmooplus.configuration.security;

import com.cliente.ws.rasmooplus.exception.NotFoundException;
import com.cliente.ws.rasmooplus.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MeuFiltro implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var userDetailOpt = userDetailsRepository.findByUsername(username);
        if (userDetailOpt.isPresent()) {
            return userDetailOpt.get();
        }
        throw new NotFoundException("Usuário não encontrado");

    }
}
