package com.cliente.ws.rasmooplus.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDto {

    private String number;

    private Long cvv;

    private Long month;

    private Long year;


    private String documentNumber;

    private Long installments;

}
