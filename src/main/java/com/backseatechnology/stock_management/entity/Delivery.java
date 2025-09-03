package com.backseatechnology.stock_management.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.backseatechnology.stock_management.utils.enums.delivery.DeliveryStatusEnum;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name="deliveries")
@EntityListeners(AuditingEntityListener.class)
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private UUID code = UUID.randomUUID();

    @ManyToOne(optional = false)
    @JoinColumn(name="branche_id")
    private Branche branche;

    @OneToOne(optional = false)
    @JoinColumn(name="sale_id")
    private Sale sale;

    @ManyToOne(optional = false)
    @JoinColumn(name="customer_id")
    private  Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name="means_transport_id")
    private  MeansTransport meansTransport;

    @Enumerated(EnumType.STRING)
    private DeliveryStatusEnum status=DeliveryStatusEnum.PENDING;

    @Column(name="delivery_address", columnDefinition = "TEXT", nullable = false)
    private String deliveryAddress;

    @Column(name="scheduled_delivery", nullable = false)
    private LocalDateTime scheduledDelivery;

    @Column(name="actual_delivery_date")
    private LocalDateTime actualDeliveryDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
