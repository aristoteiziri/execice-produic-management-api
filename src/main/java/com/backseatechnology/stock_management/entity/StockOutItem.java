package com.backseatechnology.stock_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name="stock_out_items")
public class StockOutItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="stock_out_id")
    private StockOut stockOut;

    @ManyToOne(optional = false)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name="commercial_unit_id")
    private CommercialUnit commercialUnit;

    @Column(nullable = false)
    private BigInteger quantity=BigInteger.ZERO;

    @ManyToOne(optional = false)
    @JoinColumn(name="reason_id")
    private StockOutItemReason reason;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String description;
}
