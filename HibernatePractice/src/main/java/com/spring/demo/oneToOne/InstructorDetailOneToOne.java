package com.spring.demo.oneToOne;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetailOneToOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetailOneToOne", cascade = CascadeType.ALL)
    private InstructorOneToOne instructorOneToOne;

    public InstructorDetailOneToOne() {
    }

    public InstructorOneToOne getInstructorOneToOne() {
        return instructorOneToOne;
    }

    public void setInstructorOneToOne(InstructorOneToOne instructorOneToOne) {
        this.instructorOneToOne = instructorOneToOne;
    }

    public InstructorDetailOneToOne(String youtubeChannel, String hobby) {
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
}
