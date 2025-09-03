package com.backseatechnology.stock_management.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.backseatechnology.stock_management.utils.enums.stock_request.StockRequestStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "stock_requests")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class StockRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation avec Branche
    @ManyToOne(optional = false)
    @JoinColumn(name = "branche_id", nullable = false)
    private Branche branche;

    // Champs pour la relation polymorphe manuelle
    @Column(name = "source_id", nullable = false)
    private Long sourceId;

    @Column(name = "source_type", nullable = false)
    private String sourceType;

    @Transient // Ne sera pas persisté, chargé manuellement
    private Object source;
    // Prix total (BigDecimal recommandé au lieu de BigInteger pour représenter une valeur monétaire)
    @Column(name = "total_price", precision = 15, scale = 2)
    private BigDecimal totalPrice;

    // Ce champ sera true automatiquement s'il s'agit d'une commande fournisseur
    @Column(name = "is_transfer_request", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isTransferRequest = false;

    // Statut de la demande
    @Enumerated(EnumType.STRING) // permet de stocker les valeurs de l'enum sous forme de String
    @Column(name = "status", nullable = false, length = 20)
    private StockRequestStatusEnum status = StockRequestStatusEnum.PENDING;

    // Relation avec StockRequestItem
    @OneToMany(mappedBy = "stockRequest", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<StockRequestItem> stockRequestItems;

    // Relation avec Currency
    @ManyToOne(optional = false)
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    // Description
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Audit (dates)
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
