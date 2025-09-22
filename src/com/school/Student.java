package com.school;

public class Student {
    // Private fields (encapsulation)
    private static int nextStudentIdCounter = 1;  // static counter shared by all students
    private int studentId;
    private String name;

    // Constructor
    public Student(String name) {
        this.studentId = nextStudentIdCounter++; // auto-generate ID
        this.name = name;
    }

    // Public getters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    // Optional setter if you want to allow name updates
    public void setDetails(String name) {
        this.name = name;
    }

    // Display student details
    public void displayDetails() {
        System.out.println("Student ID: S" + studentId + ", Name: " + name);
    }
}
