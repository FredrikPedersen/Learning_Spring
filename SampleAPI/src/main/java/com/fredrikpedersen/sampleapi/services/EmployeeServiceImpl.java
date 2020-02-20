package com.fredrikpedersen.sampleapi.services;


import com.fredrikpedersen.sampleapi.domain.people.Employee;
import com.fredrikpedersen.sampleapi.repositories.EmployeeRepository;
import com.fredrikpedersen.sampleapi.web.controllers.EmployeeController;
import com.fredrikpedersen.sampleapi.web.mappers.EmployeeMapper;
import com.fredrikpedersen.sampleapi.web.models.people.employee.EmployeeDTO;
import com.fredrikpedersen.sampleapi.web.util.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 18.02.2020 at 10:13
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final String URL = EmployeeController.BASE_URL;
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.
                findAll()
                .stream()
                .map(employee -> {
                    EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(employee);
                    employeeDTO.setEmployeeUrl(URL + employee.getId());
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(final Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::employeeToEmployeeDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public EmployeeDTO createNewEmployee(final EmployeeDTO employeeDTO) {
        return saveAndReturnDTO(employeeMapper.employeeDTOToEmployee(employeeDTO));
    }

    @Override
    public EmployeeDTO saveEmployeeByDTO(final Long id, final EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
        employee.setId(id);

        return saveAndReturnDTO(employee);
    }

    @Override
    public EmployeeDTO patchEmployee(final Long id, final EmployeeDTO employeeDTO) {
        return employeeRepository.findById(id).map(employee -> {
            if (employeeDTO.getFirstName() != null) {
                employee.setFirstName(employeeDTO.getFirstName());
            }

            if(employeeDTO.getLastName() != null) {
                employee.setLastName(employeeDTO.getLastName());
            }

            if(employeeDTO.getDepartment() != null) {
                employee.setDepartment(employeeDTO.getDepartment());
            }

            EmployeeDTO returnDto = employeeMapper.employeeToEmployeeDTO(employeeRepository.save(employee));
            returnDto.setEmployeeUrl(URL + id);

            return returnDto;
        }).orElseThrow(ResourceNotFoundException::new);
    }

    private EmployeeDTO saveAndReturnDTO(final Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(savedEmployee);
        employeeDTO.setEmployeeUrl(URL + savedEmployee.getId());

        return employeeDTO;
    }

    @Override
    public void deleteEmployeeById(final Long id) {
        employeeRepository.deleteById(id);
    }
}
