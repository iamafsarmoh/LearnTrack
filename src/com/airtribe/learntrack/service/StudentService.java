package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

public class StudentService {

    private final StudentRepository repo = new StudentRepository();

    public void addStudent(String fn, String ln, String email, String batch) {
        Student s = new Student(IdGenerator.nextStudentId(), fn, ln, email, batch);
        repo.save(s);
        System.out.println("Student added with ID: " + s.getId());
    }

    public Student getStudent(int id) {
        Student s = repo.findById(id);
        if (s == null) throw new EntityNotFoundException("Student not found");
        return s;
    }

    public void listStudents() {
        repo.findAll().forEach(s ->
            System.out.println(s.getId()+" | "+ s.getDisplayName() + " | Active: " + s.isActive())
        );
    }
}
