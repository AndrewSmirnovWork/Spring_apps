package com.spring.demo.mvc;

import com.spring.demo.mvc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestQuery {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            //start a transaction
            session.beginTransaction();
            //HQL
            //Query
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            for (Student tempStudent : theStudents) {
                System.out.println(tempStudent);
            }
            theStudents = session.createQuery("from Student s where s.last_name='Smirnov' ").getResultList();

            for (Student tempStudent : theStudents) {
                System.out.println(tempStudent);
            }
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
