package com.cliente.ws.rasmooplus.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "user_payment_info")
public class UserPaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_payment_info_id")
    private Long id;
    @Column(name = "card_number")
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


    public UserPaymentInfo() {
    }

    public UserPaymentInfo(Long id, String cardNumber, Long expirationMonth, Long expirationYear, String cardSecurityCode, BigDecimal price, LocalDate dtPayment, User user) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.cardSecurityCode = cardSecurityCode;
        this.price = price;
        this.dtPayment = dtPayment;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Long expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Long getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Long expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCardSecurityCode() {
        return cardSecurityCode;
    }

    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDtPayment() {
        return dtPayment;
    }

    public void setDtPayment(LocalDate dtPayment) {
        this.dtPayment = dtPayment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

