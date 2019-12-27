package com.spring.demo.uni;

import com.spring.demo.uni.Instructor;
import com.spring.demo.uni.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainAppDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            //create objects
            Instructor instructor =
                    new Instructor("Andrew2", "Smirnov2", "heregoesemail2");
            InstructorDetail instructorDetail =
                    new InstructorDetail("youbube-sucks2", "hobbyHere2");

            session.beginTransaction();
            //associate objects
            instructor.setInstructorDetail(instructorDetail);

            //save the transaction
            session.save(instructor);

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
