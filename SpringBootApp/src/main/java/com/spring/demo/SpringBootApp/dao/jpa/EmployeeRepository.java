package com.spring.demo.SpringBootApp.dao.jpa;

import com.spring.demo.SpringBootApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
