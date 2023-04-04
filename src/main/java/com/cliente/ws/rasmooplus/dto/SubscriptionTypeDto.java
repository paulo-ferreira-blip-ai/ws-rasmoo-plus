package com.cliente.ws.rasmooplus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionTypeDto {


    private Long id;
    @NotBlank(message = " Não pode ser nulo ou vazio")
    @Size(min = 5, max = 30, message = " Deve conter entre 5 e 30 caracteres")
    private String name;
    @Max(value = 12, message = " Não pode ser maior que 12")
    private Long accessMonths;
    @NotNull(message = " Não pode ser nulo")
    private BigDecimal price;
    @NotBlank(message = " Não pode ser nulo ou vazio")
    @Size(min = 5, max = 15, message = " Deve conter entre 5 e 15 caracteres")
    private String productKey;
}
