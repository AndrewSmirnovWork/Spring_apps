package com.spring.demo.SpringBootApp.rest;

import com.spring.demo.SpringBootApp.dao.EmployeeDAO;
import com.spring.demo.SpringBootApp.entity.Employee;
import com.spring.demo.SpringBootApp.exception.EmployeeNotFoundException;
import com.spring.demo.SpringBootApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestfulController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    private EmployeeService employeeService;

    @Autowired
    public RestfulController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {

        Employee employee = employeeService.findById(id);
        if(employee == null) throw new EmployeeNotFoundException(" Wrong employee " + id );
        return employee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee ==null) throw new EmployeeNotFoundException("Wrong employee " + id);
        employeeService.deleteEmployee(id);
        return "Employee deleted";
    }


}
