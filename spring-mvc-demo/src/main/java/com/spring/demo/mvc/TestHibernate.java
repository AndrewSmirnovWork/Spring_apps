package com.spring.demo.mvc;

import com.spring.demo.mvc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            Student student = new Student("Andrew", "Smirnov", "icar08@yandex.ru");
            Student student2 = new Student("Mary", "Jane", "gmail.com");
            Student student3 = new Student("Peter", "Parker", "PP@yandex.ru");

            session.beginTransaction();

/*
            session.save(student);
            session.save(student2);
            session.save(student3);
*/
            Student retriveStudent = session.get(Student.class, student2.getId());
            System.out.println(retriveStudent);

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
