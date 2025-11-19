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

        // === Create Courses with Capacity ===
        Course c1 = registrationService.createCourse("Mathematics", 2);       // capacity 2
        Course c2 = registrationService.createCourse("DBMS", 2);              // capacity 2
        Course c3 = registrationService.createCourse("Computer Science", 1);  // capacity 1

        // === Enroll Students in Courses (including one over-capacity) ===
        System.out.println("\n=== Enrolling Students in Courses (with Capacity Check) ===");
        registrationService.enrollStudentInCourse(s1, c1);
        registrationService.enrollStudentInCourse(s2, c1);

        // This will exceed capacity of c1 (Mathematics) which is 2
        registrationService.enrollStudentInCourse(s3, c1);

        // Some additional valid enrollments
        registrationService.enrollStudentInCourse(s1, c2);
        registrationService.enrollStudentInCourse(s3, c3);

        // === Display Directory AFTER enrollments (shows capacity & enrolled count) ===
        displaySchoolDirectory(registrationService);

        // === Mark Attendance (optional check: only if student is enrolled) ===
        System.out.println("\n=== Marking Attendance (only for enrolled students) ===");
        markAttendanceIfEnrolled(attendanceService, s1, c1, "Present");  // enrolled -> will be marked
        markAttendanceIfEnrolled(attendanceService, s2, c2, "ABSENT");   // enrolled -> will be marked

        // s3 is NOT enrolled in c2, so this should be blocked
        markAttendanceIfEnrolled(attendanceService, s3, c2, "Late");

        // Show attendance on console
        System.out.println();
        attendanceService.displayAttendance();

        // === Save all data to files ===
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
    }

    private static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n=== School Directory: People ===");
        for (Person p : regService.getAllPeople()) {
            p.displayDetails();
        }

        System.out.println("\n=== Courses ===");
        for (Course c : regService.getCourses()) {
            c.displayDetails();
            System.out.println("---------------------------");
        }
    }

    /**
     * Helper method: before marking attendance, check if the student
     * is enrolled in the given course.
     */
    private static void markAttendanceIfEnrolled(AttendanceService attendanceService,
                                                 Student student,
                                                 Course course,
                                                 String status) {
        if (!course.getEnrolledStudents().contains(student)) {
            System.out.println("❌ Cannot mark attendance. " + student.getName()
                    + " is not enrolled in " + course.getCourseName());
            return;
        }

        attendanceService.markAttendance(student.getId(), course.getCourseId(), status);
    }
}
