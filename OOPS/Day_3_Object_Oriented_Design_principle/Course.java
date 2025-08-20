package Day_3_Object_Oriented_Design_principle;

import java.util.*;

class Course {
    String courseName;
    List<Student> students = new ArrayList<>();

    Course(String courseName) {
        this.courseName = courseName;
    }

    void enroll(Student s) {
        students.add(s);
    }

    void showStudents() {
        System.out.println("Course: " + courseName);
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollInCourse(Course c) {
        courses.add(c);
        c.enroll(this);
    }

    void showCourses() {
        System.out.println("Student: " + name);
        for (Course c : courses) {
            System.out.println("- " + c.courseName);
        }
    }
}

class School {
    String schoolName;
    List<Student> students;

    School(String schoolName) {
        this.schoolName = schoolName;
        students = new ArrayList<>();
    }

    void addStudent(Student s) {
        students.add(s); // Aggregation
    }
}

