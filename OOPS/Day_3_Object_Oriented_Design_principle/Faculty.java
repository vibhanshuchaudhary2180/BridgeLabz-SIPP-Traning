package Day_3_Object_Oriented_Design_principle;

import java.util.List;
import java.util.ArrayList;

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Faculty: " + name);
    }
}

class Department {
    String deptName;

    Department(String deptName) {
        this.deptName = deptName;
    }

    void display() {
        System.out.println("Department: " + deptName);
    }
}

class University {
    String uniName;
    List<Department> departments;

    University(String uniName) {
        this.uniName = uniName;
        departments = new ArrayList<>();
    }

    void addDepartment(Department d) {
        departments.add(d); 
    }

    void showStructure() {
        System.out.println("University: " + uniName);
        for (Department d : departments) {
            d.display();
        }
    }
}

