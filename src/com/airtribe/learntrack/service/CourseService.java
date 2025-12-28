package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class CourseService {

    private final CourseRepository repo = new CourseRepository();

    public void addCourse(String name, String desc, int weeks) {
        Course c = new Course(IdGenerator.nextCourseId(), name, desc, weeks);
        repo.save(c);
        System.out.println("Course added with ID: " + c.getId());
    }

    public Course getCourse(int id) {
        Course c = repo.findById(id);
        if (c == null) throw new EntityNotFoundException("Course not found");
        return c;
    }

    public void listCourses() {
        repo.findAll().forEach(c ->
            System.out.println(c.getId() + " - " + c.getCourseName())
        );
    }
}
