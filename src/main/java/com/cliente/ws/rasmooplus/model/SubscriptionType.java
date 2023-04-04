package com.cliente.ws.rasmooplus.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@EqualsAndHashCode(callSuper = false) //para uso de Heteoas
@Table(name = "subscriptions_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // sera utilizado em mapeado de DTOs
public class SubscriptionType extends RepresentationModel<SubscriptionType> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriptions_type_id")
    private Long id;
    private String name;
    @Column(name = "access_months")
    private Long accessMonths;
    private BigDecimal price;
    @Column(name = "product_key", unique = true)
    private String productKey;
}