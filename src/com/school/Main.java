package com.school;

public class Main {
    public static void main(String[] args) {

        // === Create shared services ===
        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);

        // === Register Students ===
        Student s1 = registrationService.registerStudent("Alice", "Grade 10");
        Student s2 = registrationService.registerStudent("Bob", "Grade 11");
        Student s3 = registrationService.registerStudent("Sravani", "Grade 12");

        // === Register Teachers ===
        Teacher t1 = registrationService.registerTeacher("Mr. Smith", "Mathematics");
        Teacher t2 = registrationService.registerTeacher("Ms. Patel", "Computer Science");

        // === Register Staff ===
        Staff st1 = registrationService.registerStaff("Mrs. Johnson", "Librarian");
        Staff st2 = registrationService.registerStaff("Mr. Kumar", "Lab Assistant");

        // === Create Courses ===
        Course c1 = registrationService.createCourse("Mathematics");
        Course c2 = registrationService.createCourse("DBMS");
        Course c3 = registrationService.createCourse("Computer Science");

        // === Display Directory ===
        displaySchoolDirectory(registrationService);

        // === Mark Attendance using IDs ===
        attendanceService.markAttendance(s1.getId(), c1.getCourseId(), "Present");
        attendanceService.markAttendance(s2.getId(), c2.getCourseId(), "ABSENT");
        attendanceService.markAttendance(s3.getId(), c3.getCourseId(), "Late"); // invalid -> will be "Invalid"

        // Show attendance on console
        attendanceService.displayAttendance();

        // === Save all data to files ===
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
    }

    private static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("=== School Directory: People ===");
        for (Person p : regService.getAllPeople()) {
            p.displayDetails();
        }

        System.out.println("\n=== Courses ===");
        for (Course c : regService.getCourses()) {
            c.displayDetails();
        }
    }
}
