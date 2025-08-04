import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    private static final String FILE_NAME = "employees.ser";

    // Employee class inside main class for single file
    public static class Employee implements Serializable {
        private static final long serialVersionUID = 1L;

        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee {" +
                   "ID=" + id +
                   ", Name='" + name + '\'' +
                   ", Department='" + department + '\'' +
                   ", Salary=" + salary +
                   '}';
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 60000));
        employees.add(new Employee(2, "Bob", "IT", 75000));
        employees.add(new Employee(3, "Charlie", "Finance", 70000));

        serializeEmployees(employees);

        List<Employee> deserializedEmployees = deserializeEmployees();
        if (deserializedEmployees != null) {
            System.out.println("Employees read from file:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        }
    }

    public static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees have been serialized to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }

    public static List<Employee> deserializeEmployees() {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found during deserialization: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error during deserialization: " + e.getMessage());
        }
        return employees;
    }
}
