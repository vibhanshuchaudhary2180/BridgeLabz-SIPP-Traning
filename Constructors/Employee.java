class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int id, String dept, double salary) {
        this.employeeID = id;
        this.department = dept;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    public Manager(int id, String dept, double salary) {
        super(id, dept, salary);
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: ₹" + getSalary());
    }

    public static void main(String[] args) {
        Manager m = new Manager(111, "HR", 50000);
        m.displayDetails();
    }
}