package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public void save(Student s) {
        students.add(s);
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
