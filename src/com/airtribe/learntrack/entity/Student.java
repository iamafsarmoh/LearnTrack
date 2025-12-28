package com.airtribe.learntrack.entity;

public class Student extends Person {

    private String batch;
    private boolean active;

    public Student(int id, String fn, String ln, String email, String batch) {
        super(id, fn, ln, email);
        this.batch = batch;
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }

    @Override
    public String getDisplayName() {
        return "Student: " + super.getDisplayName();
    }

    public int getId() {
        return id;
    }
}
