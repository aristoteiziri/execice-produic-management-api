package com.backseatechnology.stock_management.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = {"stockRequestItems", "saleItems"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private UUID code = UUID.randomUUID();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<StockRequestItem> stockRequestItems;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_category_id", nullable = false)
    private ProductCategory productCategory;

    @ManyToOne(optional = false)
    @JoinColumn(name = "commercial_unit_id", nullable = false)
    private CommercialUnit commercialUnit;

    @Column(name = "is_vat_applicable", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isVatApplicable = false;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<SaleItem> saleItems;

    @ManyToMany(mappedBy = "products")
    private Set<DiscountCondition> discountConditions;
}
