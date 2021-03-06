package com.spring.demo.SpringBootApp.dao;

import com.spring.demo.SpringBootApp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public Employee findById(int id);

    public void saveEmployee(Employee employee);

    public void deleteEmployee(int id);


}
