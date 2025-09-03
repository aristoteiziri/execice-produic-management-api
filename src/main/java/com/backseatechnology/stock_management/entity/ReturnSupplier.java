package com.backseatechnology.stock_management.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.backseatechnology.stock_management.utils.enums.return_supplier.ReturnSupplierStatusEnum;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="return_suppliers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class ReturnSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="product_receip_id")
    private ProductReceipt productReceipt;

    @ManyToOne(optional = false)
    @JoinColumn(name="supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "returnSupplier")
    private Set<ReturnSupplierItem> returnSupplierItems;

    @Enumerated(EnumType.STRING)
    private ReturnSupplierStatusEnum status=ReturnSupplierStatusEnum.PENDING;

    @Column(columnDefinition = "TEXT")
    private String description;

    // Audit (dates)
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
