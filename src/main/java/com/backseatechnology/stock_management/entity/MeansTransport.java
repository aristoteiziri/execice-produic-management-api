package com.backseatechnology.stock_management.entity;

import com.backseatechnology.stock_management.utils.enums.means_transport.MeansTransportEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name="means_transports")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class MeansTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String model;
    private String brand;
    private String registration;

    @Column(nullable = false, unique = true)
    private String chassisNumber;

    @OneToOne(optional = false)
    @JoinColumn(name="type_transportation_id")
    private TypeTransportation typeTransportation;

    @Enumerated(EnumType.STRING)
    private MeansTransportEnum status=MeansTransportEnum.AVAILABLE;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
