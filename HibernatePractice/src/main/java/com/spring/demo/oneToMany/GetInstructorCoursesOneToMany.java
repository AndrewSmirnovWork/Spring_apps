package com.spring.demo.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesOneToMany {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorManyToOne.class)
                .addAnnotatedClass(InstructorDetailManyToOne.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            //get the instructor object
            int theId = 3;
            InstructorManyToOne instructorManyToOne = session.get(InstructorManyToOne.class, theId);
            //get courses for the instructor
            System.out.println("Instructor " + instructorManyToOne);
            System.out.println("Courses" + instructorManyToOne.getCourses());

            session.getTransaction().commit();

        }

        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
