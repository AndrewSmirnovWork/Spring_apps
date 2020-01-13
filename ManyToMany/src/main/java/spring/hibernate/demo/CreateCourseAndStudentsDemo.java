package spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring.hibernate.demo.Entity.*;

public class CreateCourseAndStudentsDemo {
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

            //create a course
            Course theCourse = new Course("Pacman");
            session.save(theCourse);
            System.out.println("Saving the course");

            //create the students
            Student studentOne = new Student("John", "Doe", "john@gmail.com");
            Student studentTwo = new Student("Mary", "Public", "mary@gmail.com");

            //add students to the course
            theCourse.addStudent(studentOne);
            theCourse.addStudent(studentTwo);

            //save the students
            System.out.println("\nSaving students...");
            session.save(studentOne);
            session.save(studentTwo);
            System.out.println("Saved studetns: " + theCourse.getStudents());

            session.getTransaction().commit();
            System.out.println("Done!");

        }

        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
