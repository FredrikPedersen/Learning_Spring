package com.fredrikpedersen.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class UnitOfMeasure {

    @Id
    private String id;
    private String description;
}
