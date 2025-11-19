package com.school;

import java.util.ArrayList;
import java.util.List;

public class Course implements Storable {
    // Private fields (encapsulation)
    private static int nextCourseIdCounter = 101;  // static counter starts at 101
    private int courseId;
    private String courseName;

    // New fields for Part 10
    private int capacity;
    private List<Student> enrolledStudents;

    // Constructor
    public Course(String courseName, int capacity) {
        this.courseId = nextCourseIdCounter++; // auto-generate ID
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    // Public getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public int getNumberOfEnrolledStudents() {
        return enrolledStudents.size();
    }

    // Optional setter if you want to allow course name updates
    public void setDetails(String courseName) {
        this.courseName = courseName;
    }

    // New method: add student with capacity check
    public boolean addStudent(Student student) {
        // Check capacity
        if (enrolledStudents.size() >= capacity) {
            return false; // course is full
        }

        // Optional: avoid duplicates (by reference; same objects are used in Main)
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }

        return true;
    }

    // Display course details
    public void displayDetails() {
        System.out.println("Course ID: C" + courseId + ", Course Name: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Currently Enrolled: " + getNumberOfEnrolledStudents() + "/" + capacity);
    }

    // Implement Storable
    @Override
    public String toDataString() {
        // Now also saving capacity to courses.txt
        return courseId + "," + courseName + "," + capacity;
    }
}
