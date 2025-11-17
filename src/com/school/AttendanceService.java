package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {

    private final List<AttendanceRecord> attendanceLog = new ArrayList<>();
    private final FileStorageService storageService;
    private final RegistrationService registrationService;

    public AttendanceService(FileStorageService storageService,
                             RegistrationService registrationService) {
        this.storageService = storageService;
        this.registrationService = registrationService;
    }

    // Mark attendance using IDs and RegistrationService lookups
    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);

        if (student == null) {
            System.out.println("[ERROR] Student with ID " + studentId + " not found.");
            return;
        }

        if (course == null) {
            System.out.println("[ERROR] Course with ID " + courseId + " not found.");
            return;
        }

        AttendanceRecord record = new AttendanceRecord(studentId, courseId, status);
        attendanceLog.add(record);
        System.out.println("[INFO] Attendance marked for Student " + studentId +
                " in Course " + courseId + " as " + record.getStatus());
    }

    public List<AttendanceRecord> getAttendanceLog() {
        return attendanceLog;
    }

    public void displayAttendance() {
        System.out.println("\n=== Attendance Records ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}
