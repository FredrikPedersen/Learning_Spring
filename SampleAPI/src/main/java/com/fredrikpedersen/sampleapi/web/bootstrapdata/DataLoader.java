package com.fredrikpedersen.sampleapi.web.bootstrapdata;

import com.fredrikpedersen.sampleapi.domain.people.Employee;
import com.fredrikpedersen.sampleapi.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 11.02.2020 at 14:22
 *
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public DataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createEmployees();
    }

    private void createEmployees() {
        System.out.println("Creating employees data...");

        Employee employee1 = new Employee();
        employee1.setFirstName("Nikita");
        employee1.setLastName("Petrovs");
        employee1.setDepartment("IT");

        Employee employee2 = new Employee();
        employee2.setFirstName("Victor");
        employee2.setLastName("Pishva");
        employee2.setDepartment("Bygg");

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
    }
}
