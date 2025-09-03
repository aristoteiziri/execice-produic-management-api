package com.backseatechnology.stock_management.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="loyalty_rules")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class LoyaltyRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "branche_id", unique = true) // 'unique = true' afin de renforcer la relation 1-to-1
    private Branche branche;

    @Column(name = "min_amount", nullable = false)
    private BigDecimal minAmount;

    @Column(name = "point_per_amount", nullable = false)
    private Integer pointPerAmount;

    @Column(name = "equivalent_value", nullable = false)
    private BigDecimal equivalentValue;

    @Column(name = "expires_in_days")
    private Integer expiresInDays; // Peut être null si les points n'expirent jamais

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
