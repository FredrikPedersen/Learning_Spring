package com.fredrikpedersen.webfluxrest.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 15/07/2021 at 17:03
 */

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    private String id;
    private String description;
}
