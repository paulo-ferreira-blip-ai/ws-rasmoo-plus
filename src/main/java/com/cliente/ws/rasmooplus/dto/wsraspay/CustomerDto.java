package com.cliente.ws.rasmooplus.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String cpf;



}
