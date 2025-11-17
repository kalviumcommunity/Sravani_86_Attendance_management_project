package com.school;

public class Teacher extends Person implements Storable {
    private String subjectTaught;

    // Constructor
    public Teacher(String name, String subjectTaught) {
        super(name);
        this.subjectTaught = subjectTaught;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    // Override displayDetails
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Teacher");
        System.out.println("Subject Taught: " + subjectTaught);
        System.out.println("-------------------------");
    }

    // Implement Storable (CSV format)
    @Override
    public String toDataString() {
        // id,name,subjectTaught
        return getId() + "," + getName() + "," + subjectTaught;
    }
}
