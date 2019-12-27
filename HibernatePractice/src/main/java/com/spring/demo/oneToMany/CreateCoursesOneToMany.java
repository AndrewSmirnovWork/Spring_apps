package com.spring.demo.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesOneToMany {
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

            Course course1 = new Course("Spring Boot");
            Course course = new Course("Spring mvc");

            instructorManyToOne.add(course1);
            instructorManyToOne.add(course);
            session.save(course);
            session.save(course1);

            session.getTransaction().commit();

        }

        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
