package com.fredrikpedersen.orderservice.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OrderLine extends BaseEntity {

    private Integer quantityOrdered;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private OrderHeader orderHeader;
}
