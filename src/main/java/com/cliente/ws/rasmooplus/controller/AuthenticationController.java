package com.cliente.ws.rasmooplus.controller;

import com.cliente.ws.rasmooplus.configuration.security.TokenConfig;
import com.cliente.ws.rasmooplus.dto.LoginDto;
import com.cliente.ws.rasmooplus.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenConfig tokenConfig;

    @PostMapping
    public ResponseEntity<String> auth(@RequestBody @Valid LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()
        );

        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            String token = tokenConfig.codificarToken(authentication);
            return ResponseEntity.status(HttpStatus.OK).body(token);
        } catch (Exception e) {
            throw new BadRequestException("Erro ao formatar Token -" + e.getMessage());
        }


    }

}
