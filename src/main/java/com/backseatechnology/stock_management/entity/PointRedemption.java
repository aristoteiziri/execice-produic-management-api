package com.backseatechnology.stock_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="point_redemptions")
@EntityListeners(AuditingEntityListener.class)
public class PointRedemption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="branche_id")
    private Branche branche;

    @OneToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name="point_used", columnDefinition = "INT UNSIGNED")
    private Integer pointUsed;

    @Column(name="amount_discounted", precision = 15, scale = 2, nullable = false)
    private BigDecimal amountDiscounted;

    @ManyToOne(optional = false)
    @JoinColumn(name="currency_id")
    private Currency currency;

    @Column(name="used_at")
    private LocalDateTime usedAt=LocalDateTime.now();

    @Column(columnDefinition = "TEXT")
    private String description;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
