package com.backseatechnology.stock_management.entity;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name="customer_point_redemption")
@EntityListeners(AuditingEntityListener.class)
public class CustomerPointRedemption {
    @EmbeddedId
    private CustomerPointRedemptionId id;

    @ManyToOne
    @MapsId("customerId") // Fait correspondre la partie "customerId" de la clé composite
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name="point_used", columnDefinition = "BIGINT UNSIGNED DEFAULT 0")
    private BigInteger pointUsed;

    @Column(name="amount_discounted", columnDefinition = "DECIMAL(15,2)")
    private BigDecimal amountDiscounted;

    @ManyToOne
    @JoinColumn(name="currency_id")
    private Currency currency;

    @Column(name="description", columnDefinition = "text", nullable = true)
    private String description;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
