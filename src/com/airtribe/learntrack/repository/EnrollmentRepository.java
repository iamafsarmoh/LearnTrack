package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

    private final List<Enrollment> enrollments = new ArrayList<>();

    public void save(Enrollment e) {
        enrollments.add(e);
    }

    public List<Enrollment> findAll() {
        return enrollments;
    }
}
