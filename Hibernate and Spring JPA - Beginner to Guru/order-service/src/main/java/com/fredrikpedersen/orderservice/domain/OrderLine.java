package com.fredrikpedersen.orderservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class OrderLine extends BaseEntity {

    private Integer quantityOrdered;

    @ManyToOne
    private OrderHeader orderHeader;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrderLine orderLine = (OrderLine) o;

        if (!Objects.equals(quantityOrdered, orderLine.quantityOrdered))
            return false;
        return Objects.equals(orderHeader, orderLine.orderHeader);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (quantityOrdered != null ? quantityOrdered.hashCode() : 0);
        return result;
    }
}
