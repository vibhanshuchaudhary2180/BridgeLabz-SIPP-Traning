// Base class
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Subclass: Teacher
class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        System.out.println("Teacher: " + name + ", teaches " + subject);
    }
}

// Subclass: Student
class Student extends Person {
    private int grade;

    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        System.out.println("Student: " + name + ", Grade: " + grade);
    }
}

// Subclass: Staff
class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        System.out.println("Staff: " + name + ", Department: " + department);
    }
}


public class SchoolSystem {
    public static void main(String[] args) {
        Teacher t = new Teacher("Alice", 35, "Mathematics");
        Student s = new Student("Bob", 15, 10);
        Staff staff = new Staff("Charlie", 40, "Administration");

        t.displayRole();
        s.displayRole();
        staff.displayRole();
    }
}
