package com.spring.demo.SpringBootApp.service;

import com.spring.demo.SpringBootApp.dao.EmployeeDAO;
import com.spring.demo.SpringBootApp.dao.jpa.EmployeeRepository;
import com.spring.demo.SpringBootApp.entity.Employee;
import com.spring.demo.SpringBootApp.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee emp = null;

        if (employee.isPresent()) {
            emp = employee.get();
        }else {
            // we didn't find the employee
            throw new EmployeeNotFoundException("Did not find employee id - " + id);
        }
        return emp;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }


    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
