package com.spring.demo.mvc;

import com.spring.demo.mvc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestQueryUpdate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            int studentId = 1;
            //start a transaction
            session.beginTransaction();
            //changing Student name with studentID = 1
            Student theStudent = session.get(Student.class, studentId);
            theStudent.setFirst_name("bezdar");

            //reading User table
            System.out.println();
            List<Student> theStudents = session.createQuery("from Student").getResultList();
            for (Student students : theStudents) {
                System.out.println(students);
            }
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student set email='gmail.com'").executeUpdate();

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
