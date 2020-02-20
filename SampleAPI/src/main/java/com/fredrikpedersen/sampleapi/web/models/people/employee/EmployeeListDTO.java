package com.fredrikpedersen.sampleapi.web.models.people.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 18.02.2020 at 09:49
 */

@Data
@AllArgsConstructor
public class EmployeeListDTO {

    private List<EmployeeDTO> employees;
}
