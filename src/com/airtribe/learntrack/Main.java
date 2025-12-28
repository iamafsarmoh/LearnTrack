package com.airtribe.learntrack;

import java.util.Scanner;

import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

public class Main {

    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService =
            new EnrollmentService(studentService, courseService);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== LearnTrack Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. Enroll Student");
            System.out.println("6. View Enrollments");
            System.out.println("0. Exit");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("First Name: ");
                        String fn = sc.nextLine();
                        System.out.print("Last Name: ");
                        String ln = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Batch: ");
                        String batch = sc.nextLine();
                        studentService.addStudent(fn, ln, email, batch);
                        break;

                    case 2:
                        studentService.listStudents();
                        break;

                    case 3:
                        System.out.print("Course Name: ");
                        String cname = sc.nextLine();
                        System.out.print("Description: ");
                        String desc = sc.nextLine();
                        System.out.print("Duration (weeks): ");
                        int weeks = Integer.parseInt(sc.nextLine());
                        courseService.addCourse(cname, desc, weeks);
                        break;

                    case 4:
                        courseService.listCourses();
                        break;

                    case 5:
                        System.out.print("Student ID: ");
                        int sid = Integer.parseInt(sc.nextLine());
                        System.out.print("Course ID: ");
                        int cid = Integer.parseInt(sc.nextLine());
                        enrollmentService.enrollStudent(sid, cid);
                        break;

                    case 6:
                        enrollmentService.viewAllEnrollments();
                        break;

                    case 0:
                        exit = true;
                        break;

                    default:
                        throw new InvalidInputException("Invalid menu option");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
