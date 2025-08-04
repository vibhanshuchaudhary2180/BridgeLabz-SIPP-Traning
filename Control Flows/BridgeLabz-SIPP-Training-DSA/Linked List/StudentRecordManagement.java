import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;

    // Add at the beginning
    public void addAtBeginning(int roll, String name, int age, String grade) {
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add at the end
    public void addAtEnd(int roll, String name, int age, String grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
    }

    // Add at specific position (0-based index)
    public void addAtPosition(int position, int roll, String name, int age, String grade) {
        if (position == 0) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        Student newStudent = new Student(roll, name, age, grade);
        Student current = head;
        for (int i = 0; current != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newStudent.next = current.next;
        current.next = newStudent;
    }

    // Delete by roll number
    public void deleteByRollNumber(int roll) {
        if (head == null) return;

        if (head.rollNumber == roll) {
            head = head.next;
            return;
        }

        Student current = head;
        while (current.next != null && current.next.rollNumber != roll) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Student with Roll No " + roll + " not found.");
            return;
        }

        current.next = current.next.next;
    }

    // Search by roll number
    public void searchByRollNumber(int roll) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == roll) {
                System.out.println("Found: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll No " + roll + " not found.");
    }

    // Update grade
    public void updateGrade(int roll, String newGrade) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == roll) {
                current.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student with Roll No " + roll + " not found.");
    }

    // Display all records
    public void displayAll() {
        Student current = head;
        if (current == null) {
            System.out.println("No student records to display.");
            return;
        }
        while (current != null) {
            System.out.println("Roll: " + current.rollNumber + ", Name: " + current.name +
                               ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        do {
            System.out.println("\nStudent Record Management System:");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            int roll, age, position;
            String name, grade;

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = scanner.nextInt();
                    name = scanner.next();
                    age = scanner.nextInt();
                    grade = scanner.next();
                    list.addAtBeginning(roll, name, age, grade);
                    break;

                case 2:
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = scanner.nextInt();
                    name = scanner.next();
                    age = scanner.nextInt();
                    grade = scanner.next();
                    list.addAtEnd(roll, name, age, grade);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    position = scanner.nextInt();
                    System.out.print("Enter Roll, Name, Age, Grade: ");
                    roll = scanner.nextInt();
                    name = scanner.next();
                    age = scanner.nextInt();
                    grade = scanner.next();
                    list.addAtPosition(position, roll, name, age, grade);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Delete: ");
                    roll = scanner.nextInt();
                    list.deleteByRollNumber(roll);
                    break;

                case 5:
                    System.out.print("Enter Roll Number to Search: ");
                    roll = scanner.nextInt();
                    list.searchByRollNumber(roll);
                    break;

                case 6:
                    System.out.print("Enter Roll Number and New Grade: ");
                    roll = scanner.nextInt();
                    grade = scanner.next();
                    list.updateGrade(roll, grade);
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 8:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
