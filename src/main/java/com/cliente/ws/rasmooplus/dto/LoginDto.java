package com.cliente.ws.rasmooplus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotBlank(message = "Atributo obrigatorio")
    private String username;

    @NotBlank(message = "Atributo obrigatorio")
    private String password;

}

