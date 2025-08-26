package com.school;

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

        // Display details
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();

        c1.displayDetails();
        c2.displayDetails();
        c3.displayDetails();
    }
}
