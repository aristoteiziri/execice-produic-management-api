package com.backseatechnology.stock_management.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "branche_id", nullable = false)
    private Branche branche;

    @OneToOne(optional = false)
    @JoinColumn(name = "sale_id", nullable = false, unique = true)
    private Sale sale;

    @ManyToOne(optional = false)
    @JoinColumn(name = "means_payment_id", nullable = false)
    private MeansPayment meansPayment;

    @Column(name = "final_amount", precision = 15, scale = 2, nullable = false)
    private BigDecimal finalAmount;

    @Column(name="source_rate", nullable = true)
    private String sourceRate;

    @Column(name="conversion_rate", precision = 20, scale = 10, nullable = true)
    private BigDecimal conversionRate;

    @ManyToOne(optional = false)
    @JoinColumn(name="currency_id")
    private Currency currency;

    @Column(name="total_cumulative_tax_amount", precision=15, scale=2, nullable=false)
    private BigDecimal totalCumulativeTaxAmount;

    @Column(name="vat_rate", precision = 5, scale = 2, nullable = false)
    private BigDecimal vatRate;

    @Column(name="discount_amount", precision=15, scale=2, nullable=false)
    private BigDecimal discountAmount;

    @Column(name="vat_amount", precision=15, scale=2, nullable=false)
    private BigDecimal vatAmount;

    @Column(name="total_amount_excluding_tax", precision=15, scale=2, nullable=false)
    private BigDecimal totalAmountExcludingTax;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String description;

    // Audit (dates)
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}

