package com.backseatechnology.stock_management.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="product_locations")
@EntityListeners(AuditingEntityListener.class)
public class ProductLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name="branche_id")
    private Branche branche;

    @ManyToOne(optional = false)
    @JoinColumn(name="product_location_type_id")
    private ProductLocationType productLocationType;

    @Column(length = 100,  nullable = false, unique = true)
    private UUID code;
    private String name;
    private String zone;
    private String section;
    private String floor;
    private String description;
    // Audit (dates)
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
