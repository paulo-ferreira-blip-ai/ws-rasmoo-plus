package com.cliente.ws.rasmooplus.dto;

import com.cliente.ws.rasmooplus.model.SubscriptionType;
import com.cliente.ws.rasmooplus.model.UserType;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    @NotBlank(message = " Valor não pode ser nulo ou vazio")
    @Size(min = 6, message = " valor mínimo igual a  6 caracteres")
    private String name;
    @Email(message = " e-mail deve ser válido")
    private String email;
    @Size(min = 11, message = " Valor mínimo igual a 11 digitos")
    private String phone;
    @CPF(message = " CPF deve ser válido")
    private String cpf;

    private LocalDate dtSubscription = LocalDate.now();

    private LocalDate dtExpiration = LocalDate.now();
    @NotNull(message = " Valor não pode ser nulo")
    private Long userTypeId;

    private Long subscriptionTypeId;


}
