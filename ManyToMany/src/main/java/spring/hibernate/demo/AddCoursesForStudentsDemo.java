package spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring.hibernate.demo.Entity.*;

public class AddCoursesForStudentsDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            //get student from th database
            int id = 6;
            Student theStudent = session.get(Student.class, id);
            System.out.println("\nLoaded Student: " + theStudent);
            System.out.println("Courses: " + theStudent.getCourses());

            //create more courses
            Course theCourse = new Course("Rubik's Cube");
            Course theCourseTwo = new Course("Atari 2600");

            //add student to courses
            theCourse.addStudent(theStudent);
            theCourseTwo.addStudent(theStudent);

            //save the courses
            System.out.println("\nSaveing courses: ...");

            session.save(theCourse);
            session.save(theCourseTwo);

            session.getTransaction().commit();
            System.out.println("Done!");

        }

        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
