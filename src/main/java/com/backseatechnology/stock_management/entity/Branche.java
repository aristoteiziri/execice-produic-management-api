package com.backseatechnology.stock_management.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.backseatechnology.stock_management.utils.enums.branche.BrancheStatusEnum;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "branches")
@EntityListeners(AuditingEntityListener.class)
public class Branche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private UUID code=UUID.randomUUID();

    @Column(nullable = false, unique = true)
    private String name;

    private String phone;
    private String description;
    private String email;

    @Column(name = "commercial_register")
    private String commercialRegister;

    @Column(name = "fiscal_identifier")
    private String fiscalIdentifier;

    private String address;
    private String city;
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branche_type_id")
    private BrancheType brancheType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BrancheStatusEnum status=BrancheStatusEnum.ACTIVE;

    @OneToMany(mappedBy = "branche", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<PointRedemption> pointRedemptions;

    @OneToMany(mappedBy = "branche", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<StockRequest> stockRequests;

    @OneToMany(mappedBy = "branche", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ProductLocation> productLocations;

    @OneToMany(mappedBy = "brancheToBeTransferredId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<StockOut> stockOuts;

    @OneToMany(mappedBy = "branche", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Sale> sales;

    @OneToMany(mappedBy = "branche", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Payment> payments;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
