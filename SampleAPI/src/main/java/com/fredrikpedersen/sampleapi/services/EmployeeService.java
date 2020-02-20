package com.fredrikpedersen.sampleapi.services;

import com.fredrikpedersen.sampleapi.web.models.people.employee.EmployeeDTO;

import java.util.List;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 18.02.2020 at 10:08
 */

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(final Long id);
    EmployeeDTO createNewEmployee(final EmployeeDTO employeeDTO);
    EmployeeDTO saveEmployeeByDTO(final Long id, final EmployeeDTO employeeDTO);
    EmployeeDTO patchEmployee(final Long id, final EmployeeDTO employeeDTO);
    void deleteEmployeeById(final Long id);

}
