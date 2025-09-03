package com.backseatechnology.stock_management.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

import com.backseatechnology.stock_management.utils.enums.commercial_unit.CommercialUnitTypeEnum;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table(name="commercial_unit")
public class CommercialUnit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;

    @Column(nullable=false)
    private String description;

    @Column(nullable=true, length=6, unique = true)
    private String abbreviation;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private CommercialUnitTypeEnum type=CommercialUnitTypeEnum.UNIT;

    @OneToMany(mappedBy = "commercialUnit")
    private Set<Product> products;
}
