package com.backseatechnology.stock_management.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="sale_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="sale_id")
    private Sale sale;

    @ManyToOne(optional = false)
    @JoinColumn(name="product_id")
    private Product product;

    @Column(nullable = false)
    private Long quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name="commercial_unit_id")
    private CommercialUnit commercialUnit;

    @Column(name="unit_price", precision=10, scale=2, nullable=false)
    private BigDecimal unitPrice;

    @ManyToOne(optional = false)
    @JoinColumn(name="currency_id")
    private Currency currency;
}
