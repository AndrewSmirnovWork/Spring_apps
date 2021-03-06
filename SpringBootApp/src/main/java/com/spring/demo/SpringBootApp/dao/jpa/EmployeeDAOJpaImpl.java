package com.spring.demo.SpringBootApp.dao.jpa;

import com.spring.demo.SpringBootApp.dao.EmployeeDAO;
import com.spring.demo.SpringBootApp.entity.Employee;
import com.spring.demo.SpringBootApp.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {

        Query query = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employeeList = query.getResultList();

        return employeeList;
    }

    @Override
    public Employee findById(int id) {

        Employee employee = entityManager.find(Employee.class, id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Wrong employee id - " + id);
        }
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee theEmployee = entityManager.merge(employee);
        employee.setId(theEmployee.getId());
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Wrong employee id - " + id);
        }
        entityManager.remove(employee);

    }
}
