package com.spring.demo.oneToMany;

import com.spring.demo.oneToOne.InstructorOneToOne;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetailManyToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetailManyToOne", cascade = CascadeType.ALL)
    private InstructorManyToOne instructorManyToOne;

    public InstructorDetailManyToOne() {
    }

    public InstructorManyToOne getInstructorManyToOne() {
        return instructorManyToOne;
    }

    public void setInstructorManyToOne(InstructorManyToOne instructorManyToOne) {
        this.instructorManyToOne = instructorManyToOne;
    }

    public InstructorDetailManyToOne(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetailManyToOne{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
