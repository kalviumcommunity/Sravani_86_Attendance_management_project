package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create Students
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");

        // Create Courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");
        Course c3 = new Course("Computer Science");

        // Display student details
        System.out.println("=== Students ===");
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();

        // Display course details
        System.out.println("\n=== Courses ===");
        c1.displayDetails();
        c2.displayDetails();
        c3.displayDetails();

        // Part 4: Attendance Log
        System.out.println("\n=== Attendance Records ===");
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Valid records
        attendanceLog.add(new AttendanceRecord(s1.getStudentId(), c1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(s2.getStudentId(), c2.getCourseId(), "ABSENT")); // case-insensitive

        // Invalid status (to test validation)
        attendanceLog.add(new AttendanceRecord(s3.getStudentId(), c3.getCourseId(), "Late"));

        // Display all attendance records
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
