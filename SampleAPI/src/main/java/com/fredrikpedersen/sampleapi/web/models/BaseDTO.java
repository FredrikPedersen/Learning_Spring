package com.fredrikpedersen.sampleapi.web.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 18.02.2020 at 09:50
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDTO {

    private Long id;
}
