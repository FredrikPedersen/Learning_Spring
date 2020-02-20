package com.fredrikpedersen.sampleapi.web.mappers;

import com.fredrikpedersen.sampleapi.domain.people.Employee;
import com.fredrikpedersen.sampleapi.web.models.people.employee.EmployeeDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 20.02.2020 at 11:20
 */
class EmployeeMapperTest {

    private final String FIRST_NAME = "Fredrik";
    private final String LAST_NAME = "Pedersen";
    private final String DEPARTMENT = "IT";
    private final Long ID = 1L;

    EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;

    @Test
    void employeeToEmployeeDTOTest() {

        //given
        Employee employee = new Employee();
        employee.setFirstName(FIRST_NAME);
        employee.setLastName(LAST_NAME);
        employee.setDepartment(DEPARTMENT);
        employee.setId(ID);

        //when
        EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(employee);

        //then
        assertEquals(FIRST_NAME, employeeDTO.getFirstName());
        assertEquals(LAST_NAME, employeeDTO.getLastName());
        assertEquals(DEPARTMENT, employeeDTO.getDepartment());
    }

    @Test
    void employeeDTOToEmployeeTest() {
        //given
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(FIRST_NAME);
        employeeDTO.setLastName(LAST_NAME);
        employeeDTO.setDepartment(DEPARTMENT);
        employeeDTO.setId(ID);

        //when
        Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);

        //then
        assertEquals(FIRST_NAME, employee.getFirstName());
        assertEquals(LAST_NAME, employee.getLastName());
        assertEquals(DEPARTMENT, employee.getDepartment());
    }
}