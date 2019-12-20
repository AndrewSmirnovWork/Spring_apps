package com.spring.demo.oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainAppDemoOneToOne {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorOneToOne.class)
                .addAnnotatedClass(InstructorDetailOneToOne.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            //create objects
            InstructorOneToOne instructorOneToOne =
                    new InstructorOneToOne("Andrew3", "Smirnov3", "heregoesemai3");
            InstructorDetailOneToOne instructorDetailOneToOne =
                    new InstructorDetailOneToOne("youbube-sucks3", "hobbyHere3");

            session.beginTransaction();
            //associate objects
            instructorOneToOne.setInstructorDetailOneToOne(instructorDetailOneToOne);

            //save the transaction
            session.save(instructorOneToOne);

            //how to delete object
            /**
             * int insturctorId = 1;
             * InstructorOneToOne instructor1 = session.get(InstructorOneToOne.class, insturctorId);
             * session.delete(instructor1);
            */


            //commit transaction
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
