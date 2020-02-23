package com.spring.demo.SpringBootApp.service;

import com.spring.demo.SpringBootApp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public Employee findById(int id);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int id);
}

