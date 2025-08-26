package com.school;

public class Student {
    private static int nextStudentIdCounter = 1;  // static counter shared by all students
    private int studentId;
    private String name;

    // Constructor
    public Student(String name) {
        this.studentId = nextStudentIdCounter++; // auto-generate ID
        this.name = name;
    }

    // Display student details
    public void displayDetails() {
        System.out.println("Student ID: S" + studentId + ", Name: " + name);
    }
}
