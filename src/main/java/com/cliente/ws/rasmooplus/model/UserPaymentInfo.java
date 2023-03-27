package com.cliente.ws.rasmooplus.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "user_payment_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_payment_info_id")
    private Long id;
    @Column(name = "card_number",unique = true)
    private String cardNumber;
    @Column(name = "card_expiration_month")
    private Long expirationMonth;
    @Column(name = "card_expiration_year")
    private Long expirationYear;
    @Column(name = "card_security_code")
    private String cardSecurityCode;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "dt_payment")

    private LocalDate dtPayment;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}

