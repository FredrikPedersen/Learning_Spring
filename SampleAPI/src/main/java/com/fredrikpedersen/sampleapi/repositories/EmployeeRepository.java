package com.fredrikpedersen.sampleapi.repositories;


import com.fredrikpedersen.sampleapi.domain.people.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Fredrik Pedersen
 * @version 1.1
 * @since 18.02.2020 at 09:43
 */

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
