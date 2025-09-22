package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create Students
        Student s1 = new Student("Alice", "Grade 10");
        Student s2 = new Student("Bob", "Grade 11");
        Student s3 = new Student("Sravani", "Grade 12");

        // Create Teachers
        Teacher t1 = new Teacher("Mr. Smith", "Mathematics");
        Teacher t2 = new Teacher("Ms. Patel", "Computer Science");

        // Create Staff
        Staff st1 = new Staff("Mrs. Johnson", "Librarian");
        Staff st2 = new Staff("Mr. Kumar", "Lab Assistant");

        // Create Courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("DBMS");
        Course c3 = new Course("Computer Science");

        // Display student details
        System.out.println("=== Students ===");
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();

        // Display teacher details
        System.out.println("\n=== Teachers ===");
        t1.displayDetails();
        t2.displayDetails();

        // Display staff details
        System.out.println("\n=== Staff ===");
        st1.displayDetails();
        st2.displayDetails();

        // Display course details
        System.out.println("\n=== Courses ===");
        c1.displayDetails();
        c2.displayDetails();
        c3.displayDetails();

        // Part 4: Attendance Log
        System.out.println("\n=== Attendance Records ===");
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Valid records using inherited getId()
        attendanceLog.add(new AttendanceRecord(s1.getId(), c1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(s2.getId(), c2.getCourseId(), "ABSENT")); // case-insensitive

        // Invalid status (to test validation)
        attendanceLog.add(new AttendanceRecord(s3.getId(), c3.getCourseId(), "Late"));

        // Display all attendance records
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
