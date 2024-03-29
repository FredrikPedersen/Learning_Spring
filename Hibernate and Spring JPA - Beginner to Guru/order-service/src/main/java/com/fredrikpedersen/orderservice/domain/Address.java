package com.fredrikpedersen.orderservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@Embeddable
@EqualsAndHashCode
public class Address {

    private String address;
    private String city;
    private String state;
    private String zipCode;
}
