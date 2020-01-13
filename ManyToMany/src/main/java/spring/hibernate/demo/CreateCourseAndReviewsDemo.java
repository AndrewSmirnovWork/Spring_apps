package spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spring.hibernate.demo.Entity.Course;
import spring.hibernate.demo.Entity.Instructor;
import spring.hibernate.demo.Entity.InstructorDetail;
import spring.hibernate.demo.Entity.Review;

public class CreateCourseAndReviewsDemo {
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

            //create a course
            Course course = new Course("MegaMan");

            //add some reviews
            course.addReview(new Review("Great course"));
            course.addReview(new Review("Cool course"));
            course.addReview(new Review("Awful course"));

            //save the course
            System.out.println("Saving the course");
            session.save(course);

            session.getTransaction().commit();
            System.out.println("Done!");

        }

        finally {
            session.close();
            sessionFactory.close();
        }

    }
}
