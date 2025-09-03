package com.backseatechnology.stock_management.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.backseatechnology.stock_management.utils.enums.sale.SaleStatusEnum;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="sales")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="branche_id")
    private Branche branche;

    @OneToOne(optional = false)
    @JoinColumn(name="sale_id")
    private Sale sale;

    @Column(name="customer_number", nullable=false)
    private String customerNumber;

    @ManyToOne(optional = true)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name="invoice_number")
    private String invoiceNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private SaleStatusEnum status=SaleStatusEnum.PENDING;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<SaleItem> saleItems;
}
