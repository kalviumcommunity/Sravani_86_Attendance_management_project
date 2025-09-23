package com.school;

public class Student extends Person implements Storable {
    private String gradeLevel;

    // Constructor
    public Student(String name, String gradeLevel) {
        super(name); // Call Person constructor to set ID and name
        this.gradeLevel = gradeLevel;
    }

    // Getter for gradeLevel
    public String getGradeLevel() {
        return gradeLevel;
    }

    // Optional setter
    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    // Override displayDetails to include role and grade
    @Override
    public void displayDetails() {
        super.displayDetails(); // Display ID and name from Person
        System.out.println("Role: Student");
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("-------------------------");
    }

    // Implement Storable
    @Override
    public String toDataString() {
        return getId() + "," + getName() + "," + gradeLevel;
    }
}
