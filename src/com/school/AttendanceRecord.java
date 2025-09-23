package com.school;

public class AttendanceRecord implements Storable {
    private int studentId;
    private int courseId;
    private String status; 

    // Constructor with validation
    public AttendanceRecord(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;

        // Validation (case-insensitive)
        if (status != null &&
            (status.equalsIgnoreCase("Present") || status.equalsIgnoreCase("Absent"))) {
            // Normalize to consistent casing
            this.status = status.equalsIgnoreCase("Present") ? "Present" : "Absent";
        } else {
            System.out.println("[WARN] Invalid attendance status: \"" + status + "\". Setting to \"Invalid\".");
            this.status = "Invalid";
        }
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getStatus() {
        return status;
    }

    // Display attendance record
    public void displayRecord() {
        System.out.println("Attendance => Student: " + studentId + ", Course: " + courseId + ", Status: " + status);
    }

    // Implement Storable (CSV format)
    @Override
    public String toDataString() {
        return studentId + "," + courseId + "," + status;
    }
}
