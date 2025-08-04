class Student {
    static String universityName = "National University";
    static int totalStudents = 0;

    final int rollNumber;
    String name;
    String grade;

    Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(11, "David", "A");
        Student s2 = new Student(12, "Emma", "B");

        s1.displayStudentDetails();
        s2.displayStudentDetails();
        displayTotalStudents();
    }
}
