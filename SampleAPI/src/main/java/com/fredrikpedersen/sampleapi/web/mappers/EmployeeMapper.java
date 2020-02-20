package com.fredrikpedersen.sampleapi.web.mappers;

import com.fredrikpedersen.sampleapi.domain.people.Employee;
import com.fredrikpedersen.sampleapi.web.models.people.employee.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 18.02.2020 at 09:45
 */

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO employeeToEmployeeDTO(final Employee employee);
    Employee employeeDTOToEmployee(final EmployeeDTO employeeDTO);

}
