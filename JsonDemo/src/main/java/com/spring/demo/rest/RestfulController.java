package com.spring.demo.rest;

import com.spring.demo.entity.Customer;
import com.spring.demo.exeption.CustomerNotFoundExeption;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestfulController {

    private List<Customer> customers;

    //define @PostConstruct to load customer data
    @PostConstruct
    public void loadList() {
        customers = new ArrayList<>();
        customers.add(new Customer("Andrew", "Smirnov"));
        customers.add(new Customer("John", "Wick"));
        customers.add(new Customer("Kianu", "Reaves"));
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

        if (customerId >= customers.size() || customerId < 0) {
            throw new CustomerNotFoundExeption("Customer id not found - " + customerId);
        }
        return customers.get(customerId);
    }
}
