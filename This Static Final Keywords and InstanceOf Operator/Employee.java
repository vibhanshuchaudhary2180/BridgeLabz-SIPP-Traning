class Employee {
    static String companyName = "Tech Solutions Ltd.";
    static int employeeCount = 0;

    final int id;
    String name, designation;

    Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        employeeCount++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + employeeCount);
    }

    void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "John", "Manager");
        Employee e2 = new Employee(2, "Sara", "Developer");

        e1.displayEmployeeDetails();
        e2.displayEmployeeDetails();
        displayTotalEmployees();
    }
}
