package com.spring.demo.mvc;

import com.spring.demo.mvc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestQueryDelete {
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
            Student theStudent = session.get(Student.class, studentId);

            //delete student with ID = 1
            session.delete(theStudent);

            session.createQuery("delete from Student where id =2").executeUpdate();

            //reading User table
            List<Student> theStudents = session.createQuery("from Student").getResultList();
            for (Student students : theStudents) {
                System.out.println(students);
            }
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}
