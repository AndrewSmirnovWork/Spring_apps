package com.spring.demo.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDemoOneToOne {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorOneToOne.class)
                .addAnnotatedClass(InstructorDetailOneToOne.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            //the instructor_detail ID
            int theId = 5;
            InstructorDetailOneToOne instructorDetailOneToOne =  session.get(InstructorDetailOneToOne.class, theId);
            session.delete(instructorDetailOneToOne);

            //print

            //commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
