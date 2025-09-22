package com.school;

public class Staff extends Person {
    private String staffRole;

    public Staff(String name, String staffRole) {
        super(name);
        this.staffRole = staffRole;
    }

    public String getStaffRole() {
        return staffRole;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Staff, Staff Role: " + staffRole);
    }
}