package com.fredrikpedersen.sampleapi.web.controllers;

import com.fredrikpedersen.sampleapi.services.EmployeeService;
import com.fredrikpedersen.sampleapi.web.models.people.employee.EmployeeDTO;
import com.fredrikpedersen.sampleapi.web.models.people.employee.EmployeeListDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 11.02.2020 at 12:47
 */

@RestController
@RequestMapping(EmployeeController.BASE_URL)
public class EmployeeController {

    public static final String BASE_URL = "/api/v1/employees/";
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public EmployeeListDTO getAllEmployees() {
        return new EmployeeListDTO(employeeService.getAllEmployees());
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO getEmployeeById(@PathVariable final Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO createNewEmployee(@RequestBody final EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO updateEmployee(@PathVariable final Long id, @RequestBody final EmployeeDTO employeeDTO) {
        return employeeService.saveEmployeeByDTO(id,employeeDTO);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO patchEmployee(@PathVariable final Long id, @RequestBody final EmployeeDTO employeeDTO) {
        return employeeService.patchEmployee(id, employeeDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable final Long id) {
        employeeService.deleteEmployeeById(id);
    }
}
