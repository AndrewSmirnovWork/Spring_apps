package com.spring.demo.SpringBootApp.dao;

import com.spring.demo.SpringBootApp.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery("from Employee", Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Employee employee = currentSession.get(Employee.class, id);

        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(employee);

    }

    @Override
    public void deleteEmployee(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Employee employee = currentSession.get(Employee.class , id);

        currentSession.delete(employee);
    }

}
