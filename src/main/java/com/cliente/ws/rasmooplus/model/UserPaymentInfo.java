package com.cliente.ws.rasmooplus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_payment_info_id")
    private Long id;

    @Column(name = "card_number", unique = true)
    private String cardNumber;

    @Column(name = "card_expiration_month")
    private Long expirationMonth;

    @Column(name = "card_expiration_year")
    private Long expirationYear;

    @Column(name = "card_security_code")
    private String cardSecurityCode;

    @Column(name = "installments")
    private Long installments;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "dt_payment")
    private LocalDate dtPayment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}

