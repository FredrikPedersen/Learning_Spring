package com.fredrikpedersen.sampleapi.web.models.people;

import com.fredrikpedersen.sampleapi.web.models.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 18.02.2020 at 09:51
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class PersonDTO extends BaseDTO {

    private String firstName;
    private String lastName;

    public PersonDTO(final Long id, final String firstName, final String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
