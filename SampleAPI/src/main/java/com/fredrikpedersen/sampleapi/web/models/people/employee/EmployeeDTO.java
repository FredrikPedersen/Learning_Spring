package com.fredrikpedersen.sampleapi.web.models.people.employee;

import com.fredrikpedersen.sampleapi.web.models.people.PersonDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 18.02.2020 at 10:20
 */

@Data
@NoArgsConstructor
public class EmployeeDTO extends PersonDTO {

    private String department;
    private String employeeUrl;

    public EmployeeDTO(final Long id, final String firstName, final String lastName, final String department, final String employeeUrl) {
        super(id, firstName, lastName);
        this.department = department;
        this.employeeUrl = employeeUrl;
    }
}
