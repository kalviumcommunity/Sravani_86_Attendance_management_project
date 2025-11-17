package com.school;

public class Staff extends Person implements Storable {
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
        System.out.println("Role: Staff");
        System.out.println("Staff Role: " + staffRole);
        System.out.println("-------------------------");
    }

    // Implement Storable (CSV format)
    @Override
    public String toDataString() {
        // id,name,staffRole
        return getId() + "," + getName() + "," + staffRole;
    }
}
