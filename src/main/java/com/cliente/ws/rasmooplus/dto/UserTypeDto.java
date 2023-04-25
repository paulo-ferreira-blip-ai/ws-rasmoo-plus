package com.cliente.ws.rasmooplus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTypeDto {

    private Long id;
    @NotBlank(message = " Valor não pode ser nulo ou vazio")
    private String name;
    @NotBlank(message = " Valor não pode ser nulo ou vazio")
    private String description;
}
