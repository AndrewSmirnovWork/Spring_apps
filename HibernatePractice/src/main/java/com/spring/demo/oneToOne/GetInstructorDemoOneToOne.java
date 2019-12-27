package com.spring.demo.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDemoOneToOne {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorOneToOne.class)
                .addAnnotatedClass(InstructorDetailOneToOne.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 5;
            InstructorDetailOneToOne instructorDetailOneToOne =  session.get(InstructorDetailOneToOne.class, theId);

            //print
            System.out.println("the instructor" + instructorDetailOneToOne);

            System.out.println("the associated insturctor" + instructorDetailOneToOne.getInstructorOneToOne());

            //commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
