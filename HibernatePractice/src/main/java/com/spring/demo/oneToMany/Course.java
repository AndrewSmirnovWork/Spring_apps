package com.spring.demo.oneToMany;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private InstructorManyToOne instructorManyToOne;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public InstructorManyToOne getInstructorManyToOne() {
        return instructorManyToOne;
    }

    public void setInstructorManyToOne(InstructorManyToOne instructorManyToOne) {
        this.instructorManyToOne = instructorManyToOne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
