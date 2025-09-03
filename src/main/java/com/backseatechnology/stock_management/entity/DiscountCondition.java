package com.backseatechnology.stock_management.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name="discount_conditions")
@EntityListeners(AuditingEntityListener.class)
public class DiscountCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="branche_id")
    private Branche branch;

    @ManyToMany
    @JoinTable(
            name="discount_product",
            joinColumns = @JoinColumn(name="discount_condition_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private Set<Product> products;

    @Column(nullable = false)
    private String name;

    @Column( scale = 2, precision = 5)
    private BigDecimal percentage;

    @Column(name="fixed_amount", precision = 15, scale = 2)
    private BigDecimal fixedAmount;

    @Column(name="min_condition", precision = 15, nullable = false, scale = 2)
    private BigDecimal minCondition;

    @ManyToOne(optional = false)
    @JoinColumn(name="currency_id")
    private Currency currency;

    @Column(nullable = false, name = "eligible_customer")
    private Boolean eligibleCustomer=false;

    @Column(nullable = false, name = "specific_product")
    private Boolean specificProduct=false;

    @Column(nullable = false, name = "vat_inclused")
    private Boolean vatInclused=false;

    @Column(nullable = false)
    private Boolean cumulable=false;

    @Column(nullable = false, name = "start_date")
    private Date startDate;

    @Column(nullable = true, name = "end_date")
    private Date endDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
