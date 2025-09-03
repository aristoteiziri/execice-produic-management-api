package com.backseatechnology.stock_management.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "stock_request_items")
public class StockRequestItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation avec StockRequest
    @ManyToOne(optional = false)
    @JoinColumn(name = "stock_request_id", nullable = false)
    private StockRequest stockRequest;

    // Relation avec Product
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Quantité avec valeur par défaut
    @Column(name = "quantity", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int quantity = 0;

    // Prix unitaire (DECIMAL 15,2 en base)
    @Column(name = "unit_price", nullable = false, precision = 15, scale = 2)
    private BigDecimal unitPrice;

    // Relation avec Currency (facultative)
    @ManyToOne(optional = true)
    @JoinColumn(name = "currency_id")
    private Currency currency;

    // Relation avec CommercialUnit
    @ManyToOne(optional = false)
    @JoinColumn(name = "commercial_unit_id", nullable = false)
    private CommercialUnit commercialUnit;

    @Column(name="observation", nullable = false, columnDefinition = "text")
    private String observation;
}
