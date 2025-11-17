package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {

    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Staff> staffMembers = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    private final FileStorageService storageService;

    public RegistrationService(FileStorageService storageService) {
        this.storageService = storageService;
    }

    // ---- Registration methods ----
    public Student registerStudent(String name, String gradeLevel) {
        Student student = new Student(name, gradeLevel);
        students.add(student);
        return student;
    }

    public Teacher registerTeacher(String name, String subjectTaught) {
        Teacher teacher = new Teacher(name, subjectTaught);
        teachers.add(teacher);
        return teacher;
    }

    public Staff registerStaff(String name, String staffRole) {
        Staff staff = new Staff(name, staffRole);
        staffMembers.add(staff);
        return staff;
    }

    public Course createCourse(String courseName) {
        Course course = new Course(courseName);
        courses.add(course);
        return course;
    }

    // ---- Getters ----
    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    // ---- Lookups ----
    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public Course findCourseById(int courseId) {
        for (Course c : courses) {
            if (c.getCourseId() == courseId) {
                return c;
            }
        }
        return null;
    }

    // All people (for directory display)
    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();
        people.addAll(students);
        people.addAll(teachers);
        people.addAll(staffMembers);
        return people;
    }

    // ---- Persistence ----
    public void saveAllRegistrations() {
        storageService.saveData(students, "students.txt");
        storageService.saveData(teachers, "teachers.txt");
        storageService.saveData(staffMembers, "staff.txt");
        storageService.saveData(courses, "courses.txt");
    }
}
