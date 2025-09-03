package com.backseatechnology.stock_management.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "stocks")
@EntityListeners(AuditingEntityListener.class)
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation avec Branche
    @ManyToOne(optional = false)
    @JoinColumn(name = "branche_id", nullable = false)
    private Branche branche;

    // Relation avec Product
    @OneToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;

    // Relation avec ProductLocation
    @OneToOne(optional = false)
    @JoinColumn(name = "product_location_id", nullable = false, unique = true)
    private ProductLocation productLocation;

    // Stock actuel
    @Column(name = "current_stock", nullable = false)
    private Long currentStock = 0L;

    // Stock de sécurité
    @Column(name = "safety_stock", nullable = true)
    private int safetyStock = 0;

    // Stock maximum
    @Column(name = "stock_max", nullable = true)
    private Long stockMax;

    // Stock critique
    @Column(name = "critical_stock", nullable = true)
    private int criticalStock;

    // Audit (dates)
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relation avec StockMovement
    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<StockMovement> stockMovements;
}
