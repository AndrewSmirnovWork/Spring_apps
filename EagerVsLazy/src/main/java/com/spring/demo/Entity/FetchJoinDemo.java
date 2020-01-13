package com.spring.demo.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
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
            Query<Instructor> query =
                    session.createQuery("select i from Instructor i" +
                            " JOIN FETCH i.courses" +
                            " where i.id=:theInstructorId", Instructor.class);

            //set parameter on query
            query.setParameter("theInstructorId", theId);

            //execute query and get instructor
            Instructor instructor = query.getSingleResult();

            System.out.println("Instructor " + instructor);

            session.getTransaction().commit();

            session.close();

            System.out.println("Session is now closed!");
            System.out.println("Courses: " + instructor.getCourses());
        }

        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
