package com.spring.demo.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewsDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            int theId = 4;
            //get the course
            Course theCourse = session.get(Course.class, theId);

            //print the course
            session.delete(theCourse);


            session.getTransaction().commit();
            System.out.println("Done!");

        }

        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
