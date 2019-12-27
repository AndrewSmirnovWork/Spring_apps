package com.spring.demo.HibernatePractice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Instructor")
public class Instructor {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = )
    private String lastName;
    private String email;
    @Id
    @Column(name = "id")
    private int id;


}
