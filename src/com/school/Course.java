package com.school;

public class Course implements Storable {
    // Private fields (encapsulation)
    private static int nextCourseIdCounter = 101;  // static counter starts at 101
    private int courseId;
    private String courseName;

    // Constructor
    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++; // auto-generate ID
        this.courseName = courseName;
    }

    // Public getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    // Optional setter if you want to allow course name updates
    public void setDetails(String courseName) {
        this.courseName = courseName;
    }

    // Display course details
    public void displayDetails() {
        System.out.println("Course ID: C" + courseId + ", Course Name: " + courseName);
    }

    // Implement Storable
    @Override
    public String toDataString() {
        return courseId + "," + courseName;
    }
}
