package com.cliente.ws.rasmooplus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentProcessDto {

    @NotBlank(message = "O ProductKey deve ser informado")
    private String productKey;

    private BigDecimal discount;

    @NotNull(message = " Dados do pagamento devem ser informados")
    @JsonProperty("userPaymentInfo")
    private UserPaymentInfoDto userPaymentInfoDto;


}
