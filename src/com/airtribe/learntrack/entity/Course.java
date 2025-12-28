package com.airtribe.learntrack.entity;

public class Course {

    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private boolean active;

    public Course(int id, String name, String desc, int weeks) {
        this.id = id;
        this.courseName = name;
        this.description = desc;
        this.durationInWeeks = weeks;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean isActive() {
        return active;
    }
}
