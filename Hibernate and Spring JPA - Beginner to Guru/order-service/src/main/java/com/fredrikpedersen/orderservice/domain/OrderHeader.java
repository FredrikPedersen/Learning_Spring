package com.fredrikpedersen.orderservice.domain;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OrderHeader extends BaseEntity {

    private String customer;

    public OrderHeader(final String customer) {
        this.customer = customer;
    }
}
