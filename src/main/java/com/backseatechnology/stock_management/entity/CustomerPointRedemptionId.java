package com.backseatechnology.stock_management.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode // Parfait pour une classe ID, car il utilise tous les champs par défaut.
public class CustomerPointRedemptionId implements Serializable {
    @Column(name="customer_id")
    private Long customerId;

    @Column(name="point_redemption_id")
    private Long pointRedemptionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerPointRedemptionId that = (CustomerPointRedemptionId) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(pointRedemptionId, that.pointRedemptionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, pointRedemptionId);
    }
}
