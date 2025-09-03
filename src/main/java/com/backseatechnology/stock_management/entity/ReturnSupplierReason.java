package com.backseatechnology.stock_management.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="return_supplier_reasons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReturnSupplierReason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
}
