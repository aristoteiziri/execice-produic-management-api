package com.backseatechnology.stock_management.entity;

import com.backseatechnology.stock_management.utils.enums.produit_receipt.ProduitReceiptStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name="product_receipts")
@EntityListeners(AuditingEntityListener.class)
public class ProductReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private UUID code;

    @ManyToOne(optional = false)
    @JoinColumn(name="branche_id")
    private Branche branch;

    @ManyToOne(optional = true)
    @JoinColumn(name="stock_request_id")
    private StockRequest stockRequest;

    // Champs pour la relation polymorphe manuelle
    @Column(name = "source_id", nullable = false)
    private Long sourceId;

    @Column(name = "source_type", nullable = false)
    private String sourceType;

    @Transient // Ne sera pas persisté, chargé manuellement
    private Object source;

    @Enumerated(EnumType.STRING)
    private ProduitReceiptStatusEnum status=ProduitReceiptStatusEnum.PENDING;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    // Audit (dates)
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
