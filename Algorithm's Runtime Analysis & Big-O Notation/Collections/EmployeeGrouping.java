import java.util.*;

public class EmployeeGrouping {

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();

        for (Employee e : employees) {
            grouped.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }

        return grouped;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> grouped = groupByDepartment(employees);

        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // Output:
        // HR: [Alice, Carol]
        // IT: [Bob]
    }
}
