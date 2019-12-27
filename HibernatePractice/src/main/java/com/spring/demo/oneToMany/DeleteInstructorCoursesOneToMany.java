package com.spring.demo.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorCoursesOneToMany {
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
            int theId = 4;
            Course tempCurse = session.get(Course.class, theId);
            //get courses for the instructor
            session.delete(tempCurse);

            session.getTransaction().commit();

        }

        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
