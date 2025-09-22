package com.school;

public class Teacher extends Person {
    private String subjectTaught;

    // Constructor
    public Teacher(String name, String subjectTaught) {
        super(name);
        this.subjectTaught = subjectTaught;
    }

    // Override displayDetails
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Teacher");
        System.out.println("Subject Taught: " + subjectTaught);
        System.out.println("-------------------------");
    }
}
