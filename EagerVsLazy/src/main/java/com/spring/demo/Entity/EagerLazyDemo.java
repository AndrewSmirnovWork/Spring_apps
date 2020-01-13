package com.spring.demo.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            //get the instructor object
            int theId = 3;
            Instructor instructor = session.get(Instructor.class, theId);

            //get courses for the instructor
            System.out.println("Instructor " + instructor);
            System.out.println("Courses" + instructor.getCourses());

            session.getTransaction().commit();

        }

        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
