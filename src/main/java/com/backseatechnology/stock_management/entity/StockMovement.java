package com.backseatechnology.stock_management.entity;


import com.backseatechnology.stock_management.utils.enums.stock_movement.StockMovementTypeEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="stock_movements")
@EntityListeners(AuditingEntityListener.class)
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @Column(name="initial_stock", nullable = false)
    private BigInteger initialStok=BigInteger.ZERO;

    @Column(name="final_stock", nullable = false)
    private BigInteger finalStok=BigInteger.ZERO;
    
    @Enumerated(EnumType.STRING)
    private StockMovementTypeEnum movementType=StockMovementTypeEnum.SALE;

    // Audit (dates)
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
