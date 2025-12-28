package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

public class EnrollmentService {

    private final EnrollmentRepository repo = new EnrollmentRepository();
    private final StudentService studentService;
    private final CourseService courseService;

    public EnrollmentService(StudentService ss, CourseService cs) {
        this.studentService = ss;
        this.courseService = cs;
    }

    public void enrollStudent(int sid, int cid) {
        studentService.getStudent(sid);
        courseService.getCourse(cid);

        Enrollment e = new Enrollment(IdGenerator.nextEnrollmentId(), sid, cid);
        repo.save(e);
        System.out.println("Enrollment successful");
    }

    public void viewAllEnrollments() {

    if (repo.findAll().isEmpty()) {
        System.out.println("No enrollments found.");
        return;
    }

    System.out.println("\n--- All Enrollments ---");

    for (Enrollment e : repo.findAll()) {

        Student student = studentService.getStudent(e.getStudentId());
        Course course = courseService.getCourse(e.getCourseId());

        System.out.println(
            "Enrollment ID: " + e.getId()
            + " | Student: " + student.getDisplayName()
            + " | Course: " + course.getCourseName()
            + " | Status: " + e.getStatus()
            + " | Date: " + e.getEnrollmentDate()
        );
    }
}

}
