package com.backseatechnology.stock_management.entity;

import com.backseatechnology.stock_management.utils.enums.stock_out.StockOutReasonEnum;
import com.backseatechnology.stock_management.utils.enums.stock_request.StockRequestStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="stock_outs")
@EntityListeners(AuditingEntityListener.class)
public class StockOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "branche_id", nullable = false)
    private Branche branche;

    @Enumerated(EnumType.STRING)
    private StockRequestStatusEnum status=StockRequestStatusEnum.IN_PROGRESS;

    @Enumerated(EnumType.STRING)
    private StockOutReasonEnum reason=StockOutReasonEnum.REMOVE;

    @ManyToOne(optional = true)
    @JoinColumn(name = "branche_to_be_transferred_id", nullable = true)
    private Branche brancheToBeTransferredId;

    // Description
    @Column(name = "description", columnDefinition = "TEXT", nullable = true)
    private String description;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
