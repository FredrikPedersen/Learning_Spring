package com.fredrikpedersen.sampleapi.services;

import com.fredrikpedersen.sampleapi.domain.people.Employee;
import com.fredrikpedersen.sampleapi.repositories.EmployeeRepository;
import com.fredrikpedersen.sampleapi.web.controllers.EmployeeController;
import com.fredrikpedersen.sampleapi.web.mappers.EmployeeMapper;
import com.fredrikpedersen.sampleapi.web.models.people.employee.EmployeeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 20.02.2020 at 11:17
 */

class EmployeeServiceImplTest {

    private final String FIRST_NAME = "Fredrik";
    private final String URL = EmployeeController.BASE_URL;
    private final Long ID = 1L;

    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        employeeService = new EmployeeServiceImpl(EmployeeMapper.INSTANCE, employeeRepository);
    }

    @Test
    void getAllEmployeesTest() {

        //given
        List<Employee> customers = Arrays.asList(new Employee(), new Employee(), new Employee());
        when(employeeRepository.findAll()).thenReturn(customers);

        //when
        List<EmployeeDTO> employees = employeeService.getAllEmployees();

        //then
        assertEquals(3, employees.size());
    }

    @Test
    void getEmployeeByIdTest() {

        //given
        Employee employee = new Employee();
        employee.setId(ID);
        employee.setFirstName(FIRST_NAME);

        when(employeeRepository.findById(anyLong())).thenReturn(java.util.Optional.of(employee));

        //when
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(ID);

        //then
        assertEquals(FIRST_NAME, employeeDTO.getFirstName());
    }

    @Test
    void createNewEmployeeTest() {

        //given
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(FIRST_NAME);

        Employee savedEmployee = new Employee();
        savedEmployee.setFirstName(employeeDTO.getFirstName());
        savedEmployee.setLastName(employeeDTO.getLastName());
        savedEmployee.setId(ID);

        when(employeeRepository.save(any(Employee.class))).thenReturn(savedEmployee);

        //when
        EmployeeDTO savedDto = employeeService.createNewEmployee(employeeDTO);

        //then
        assertEquals(employeeDTO.getFirstName(), savedDto.getFirstName());
        assertEquals(URL + ID, savedDto.getEmployeeUrl());
    }

    @Test
    void saveEmployeeByDTOTest() {
        //given
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(FIRST_NAME);

        Employee savedEmployee = new Employee();
        savedEmployee.setFirstName(employeeDTO.getFirstName());
        savedEmployee.setLastName(employeeDTO.getLastName());
        savedEmployee.setId(ID);

        when(employeeRepository.save(any(Employee.class))).thenReturn(savedEmployee);

        //when
        EmployeeDTO savedDto = employeeService.saveEmployeeByDTO(ID, employeeDTO);

        //then
        assertEquals(employeeDTO.getFirstName(), savedDto.getFirstName());
        assertEquals(URL + ID, savedDto.getEmployeeUrl());
    }

    @Test
    void patchEmployeeTest() {

        //given
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(FIRST_NAME);
    }

    @Test
    void deleteEmployeeByIdTest() {
        employeeRepository.deleteById(ID);
        verify(employeeRepository, times(1)).deleteById(anyLong());
    }
}