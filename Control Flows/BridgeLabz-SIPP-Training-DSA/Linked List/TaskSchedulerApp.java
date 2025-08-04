import java.util.Scanner;

class Task {
    int id;
    String name;
    String priority;
    String dueDate;
    Task next;

    public Task(int id, String name, String priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task current = null; // For viewing and rotating tasks

    // Add at the beginning
    public void addAtBeginning(int id, String name, String priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = newTask;
        } else {
            newTask.next = head;
            tail.next = newTask;
            head = newTask;
        }
        current = head;
    }

    // Add at the end
    public void addAtEnd(int id, String name, String priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = newTask;
        } else {
            tail.next = newTask;
            newTask.next = head;
            tail = newTask;
        }
        current = head;
    }

    // Add at a specific position (0-based)
    public void addAtPosition(int position, int id, String name, String priority, String dueDate) {
        if (position == 0 || head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        int index = 0;

        while (index < position - 1 && temp.next != head) {
            temp = temp.next;
            index++;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }
    }

    // Remove by Task ID
    public void removeById(int id) {
        if (head == null) return;

        Task currentTask = head;
        Task previous = tail;

        do {
            if (currentTask.id == id) {
                if (currentTask == head) {
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else {
                    previous.next = currentTask.next;
                    if (currentTask == tail) {
                        tail = previous;
                    }
                }
                System.out.println("Task ID " + id + " removed.");
                return;
            }
            previous = currentTask;
            currentTask = currentTask.next;
        } while (currentTask != head);

        System.out.println("Task ID " + id + " not found.");
    }

    // View current task and move to next
    public void viewCurrentAndMoveNext() {
        if (current == null) {
            System.out.println("No tasks scheduled.");
            return;
        }

        System.out.println("Current Task -> ID: " + current.id + ", Name: " + current.name +
                ", Priority: " + current.priority + ", Due: " + current.dueDate);
        current = current.next;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        System.out.println("All Scheduled Tasks:");
        Task temp = head;
        do {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name +
                    ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by Priority
    public void searchByPriority(String priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        boolean found = false;
        Task temp = head;
        do {
            if (temp.priority.equalsIgnoreCase(priority)) {
                System.out.println("Found -> ID: " + temp.id + ", Name: " + temp.name +
                        ", Due: " + temp.dueDate + ", Priority: " + temp.priority);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }
}

public class TaskSchedulerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();
        int choice;

        do {
            System.out.println("\nTask Scheduler Menu:");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task & Move Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Tasks by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            int id, position;
            String name, priority, dueDate;

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID, Name, Priority, Due Date: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    name = scanner.nextLine();
                    priority = scanner.nextLine();
                    dueDate = scanner.nextLine();
                    scheduler.addAtBeginning(id, name, priority, dueDate);
                    break;

                case 2:
                    System.out.print("Enter Task ID, Name, Priority, Due Date: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    name = scanner.nextLine();
                    priority = scanner.nextLine();
                    dueDate = scanner.nextLine();
                    scheduler.addAtEnd(id, name, priority, dueDate);
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    position = scanner.nextInt();
                    System.out.print("Enter Task ID, Name, Priority, Due Date: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    name = scanner.nextLine();
                    priority = scanner.nextLine();
                    dueDate = scanner.nextLine();
                    scheduler.addAtPosition(position, id, name, priority, dueDate);
                    break;

                case 4:
                    System.out.print("Enter Task ID to Remove: ");
                    id = scanner.nextInt();
                    scheduler.removeById(id);
                    break;

                case 5:
                    scheduler.viewCurrentAndMoveNext();
                    break;

                case 6:
                    scheduler.displayAllTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority to Search: ");
                    scanner.nextLine();
                    priority = scanner.nextLine();
                    scheduler.searchByPriority(priority);
                    break;

                case 8:
                    System.out.println("Exiting Task Scheduler.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        scanner.close();
    }
}
