package com.spring.demo.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainAppDemoOneToMany {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorManyToOne.class)
                .addAnnotatedClass(InstructorDetailManyToOne.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{

            InstructorManyToOne instructorManyToOne = new InstructorManyToOne("Andrew", "Smirnov", "cool@mail.com");
            InstructorDetailManyToOne instructorDetailManyToOne = new InstructorDetailManyToOne("youbie", "games");
            //associate objects
            instructorManyToOne.setInstructorDetailManyToOne(instructorDetailManyToOne);

            InstructorManyToOne instructorManyToOne3 = new InstructorManyToOne("Andrewhappy", "Smirnovhappy", "coolhappy@mail.com");
            InstructorDetailManyToOne instructorDetailManyToOne3 = new InstructorDetailManyToOne("happyyoutube", "youtube-kappa");
            instructorManyToOne3.setInstructorDetailManyToOne(instructorDetailManyToOne3);

            InstructorManyToOne instructorManyToOne1 = new InstructorManyToOne("Andrewsad", "Smirnovsad", "coolsad@mail.com");
            InstructorDetailManyToOne instructorDetailManyToOne1 = new InstructorDetailManyToOne("sadyoutube", "table-games");
            instructorManyToOne1.setInstructorDetailManyToOne(instructorDetailManyToOne1);

            session.beginTransaction();

            //get the instructor object
            int theId = 2;
           /* InstructorManyToOne instructorManyToOne = session.get(InstructorManyToOne.class, theId);

            System.out.println("instructor " + instructorManyToOne);

            System.out.println("associated instructor " + instructorManyToOne.getCourses());*/
            session.save(instructorManyToOne);
            session.save(instructorManyToOne3);
            session.save(instructorManyToOne1);
            session.getTransaction().commit();
        }

        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
