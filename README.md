# Attendance Management Project

This is the starter setup for the Attendance Management System built using Java and Object-Oriented Programming concepts.

## Author
- sravani
- squad_86

## Structure

- Java Source: `src/com/school/Main.java`

## Setup Instructions

1. Compile using: `javac src/com/school/Main.java`
2. Run using: `java -cp src com.school.Main`

## Session 2: Core Domain Modelling
- Defined `Student` class with `studentId`, `name`, `setDetails()`, and `displayDetails()` method.
- Defined `Course` class with `courseId`, `courseName`, `setDetails()`, and `displayDetails()` method.
- Utilized arrays of objects in `Main.java` to manage and display multiple students and courses.
- Introduced basic usage of `this` keyword.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/Student.java src/com/school/Course.java src/com/school/Main.java` (or `javac src/com/school/*.java`)
3. Run: `java -cp src com.school.Main`



## Part 3: Constructor Initialization & Auto-ID Generation
- Implemented parameterized constructors in `Student` and `Course` classes for object initialization.
- Utilized `private static` member variables for automatic and unique ID generation.
- Demonstrated the use of the `this` keyword to distinguish instance variables from constructor parameters.
- Changed `Course`'s `courseId` to `int` for simpler auto-generation and updated its display.
- Updated `Main.java` to use constructors and show ID progression.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`

## Part 4: Data Encapsulation & Attendance Recording Validation
- Applied encapsulation to `Student` and `Course` classes by making fields `private` and adding public `getters`.
- Introduced a new `AttendanceRecord` class with `private` fields, a constructor, and `getters` to store attendance data.
- Implemented basic validation in the `AttendanceRecord` constructor for the attendance status (allowing only "Present" or "Absent").
- Used an `ArrayList` in `Main.java` to store and display `AttendanceRecord` objects.
- Demonstrated retrieving IDs using getters when creating records.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`

## Part 5: Establishing Students, Teaching & Non-Teaching Staff hierarchy
- Created a base class `Person.java` with common attributes (`id`, `name`), a universal auto-ID generator, and a `displayDetails()` method.
- Modified `Student.java` to inherit from `Person`, using `super()` to call the parent constructor and overriding `displayDetails()` to add student-specific info (e.g., grade level).
- Created `Teacher.java` extending `Person`, adding a `subjectTaught` attribute and its own `displayDetails()`.
- Created `Staff.java` extending `Person`, adding a `role` attribute and its own `displayDetails()`.
- Demonstrated creation and display of `Student`, `Teacher`, and `Staff` objects in `Main.java`.
- Updated `AttendanceRecord` creation to use the inherited `getId()` method.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`

## Part 6: Interface-Driven Persistence with Storage
- Defined a `Storable` interface with a `toDataString()` method.
- Modified `Student`, `Course`, and `AttendanceRecord` classes to implement `Storable`.
- Created `FileStorageService` with `saveData(List<? extends Storable> items, String filename)` that writes CSV lines to a file.
- Demonstrated in `Main` how to save lists to `students.txt`, `courses.txt`, and `attendance_log.txt`.

### How to Run
1. From project root: `javac src/com/school/*.java`
2. Run: `java -cp src com.school.Main`
3. Check output files: `students.txt`, `courses.txt`, `attendance_log.txt`
Mentor: “Update README.md.”
## Part 9: SOLID Service Layer: RegistrationService & AttendanceService Separation
- Applied the Single Responsibility Principle (SRP) by creating dedicated service classes.
- Created `RegistrationService.java` to handle the registration, management (lists, lookups), and saving of `Student`, `Teacher`, `Staff`, and `Course` entities.
- Modified `Teacher.java` and `Staff.java` to implement `Storable` for file persistence.
- Refactored `AttendanceService.java`:
    - It now depends on `RegistrationService` for looking up students/courses by ID.
    - Removed internal lookup helper methods, delegating this to `RegistrationService`.
    - Its primary focus is now solely on managing attendance records.
- Updated `Main.java` to act as an orchestrator, instantiating and using these services. Direct entity list management was removed from `Main`.
- Demonstrated improved code organization and clearer separation of concerns.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`
4. Check for `students.txt`, `teachers.txt`, `staff.txt`, `courses.txt`, and `attendance_log.txt`.


## Part 10: Capacity Management & SOLID Principles Reflection
- Added a `capacity` feature to the `Course` class, along with an internal list of `enrolledStudents`.
- Updated `Course.displayDetails()` to show capacity and enrollment count, and `Course.toDataString()` to save capacity.
- Modified `RegistrationService`:
  - `createCourse` method now accepts a capacity parameter.
  - Added `enrollStudentInCourse(Student student, Course course)` method to handle enrollment logic, checking against course capacity.
- Updated `Main.java` to demonstrate course creation with capacity, student enrollment attempts (including exceeding capacity), and displaying updated course information.
- Discussed how other SOLID principles (like Open-Closed and Dependency Inversion) could be applied for further enhancements and flexibility.
- Concluded the 10-part project, having built a foundational console-based attendance system.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`
4. Check `courses.txt` for the capacity field and other files for their respective data.
