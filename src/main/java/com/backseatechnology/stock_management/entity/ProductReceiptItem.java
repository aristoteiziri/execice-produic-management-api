package com.backseatechnology.stock_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "product_receipt_items")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProductReceiptItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_receipt_id", nullable = false)
    private ProductReceipt productReceipt;

    @OneToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Optionnel
    @OneToOne(optional = true)
    @JoinColumn(name = "stock_request_item_id")
    private StockRequestItem stockRequestItem;

    @Column(nullable = false)
    private Long quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "commercial_unit_id", nullable = false)
    private CommercialUnit commercialUnit;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date expirationDate;
}
