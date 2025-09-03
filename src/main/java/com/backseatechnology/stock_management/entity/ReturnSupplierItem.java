package com.backseatechnology.stock_management.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="return_supplier_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReturnSupplierItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="return_supplier_id")
    private ReturnSupplier returnSupplier;

    @OneToOne(optional = false)
    @JoinColumn(name="product_id")
    private Product product;

    @OneToOne(optional = false)
    @JoinColumn(name="product_receipt_item_id")
    private ProductReceiptItem productReceiptItem;

    @Column(nullable = false)
    private Long quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "commercial_unit_id", nullable = false)
    private CommercialUnit commercialUnit;

    @ManyToOne(optional = false)
    @JoinColumn(name = "reason_id")
    private ReturnSupplierReason reason;
}
