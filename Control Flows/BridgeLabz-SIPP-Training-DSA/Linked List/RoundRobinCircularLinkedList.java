class Process {
    int pid;
    int burstTime;
    int priority;
    int waitingTime = 0;
    int turnAroundTime = 0;
    Process next;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinCircularLinkedList {
    Process tail = null;  // tail points to last node (to make circular)

    // Add process at end of circular list
    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (tail == null) {
            tail = newProcess;
            tail.next = tail;  // circular link to itself
        } else {
            newProcess.next = tail.next;
            tail.next = newProcess;
            tail = newProcess;
        }
    }

    // Remove process by PID (after its execution is done)
    public void removeProcess(int pid) {
        if (tail == null) return;

        Process curr = tail.next;
        Process prev = tail;
        do {
            if (curr.pid == pid) {
                if (curr == tail && curr.next == tail) {
                    // only one process
                    tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == tail) {
                        tail = prev;
                    }
                }
                break;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);
    }

    // Display current processes in circular queue
    public void displayProcesses() {
        if (tail == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process curr = tail.next;
        System.out.print("Processes in queue: ");
        do {
            System.out.print("[PID:" + curr.pid + ", BT:" + curr.burstTime + ", PR:" + curr.priority + "] -> ");
            curr = curr.next;
        } while (curr != tail.next);
        System.out.println("(back to start)");
    }

    // Simulate round robin scheduling
    public void simulateRoundRobin(int timeQuantum) {
        if (tail == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalProcesses = 0;
        Process curr = tail.next;
        do {
            totalProcesses++;
            curr = curr.next;
        } while (curr != tail.next);

        int time = 0;
        int completedProcesses = 0;


        Process currentProcess = tail.next;

        while (tail != null) {
            if (currentProcess.burstTime > 0) {
                int execTime = Math.min(timeQuantum, currentProcess.burstTime);
                System.out.println("Executing PID " + currentProcess.pid + " for " + execTime + " units.");
                time += execTime;
                currentProcess.burstTime -= execTime;

                // Update waiting time for all other processes still in queue
                Process temp = currentProcess.next;
                while (temp != currentProcess) {
                    if (temp.burstTime > 0)
                        temp.waitingTime += execTime;
                    temp = temp.next;
                }

                // If process finished execution, calculate turn-around time and remove it
                if (currentProcess.burstTime == 0) {
                    currentProcess.turnAroundTime = time;
                    System.out.println("Process PID " + currentProcess.pid + " finished at time " + time);
                    Process toRemove = currentProcess;
                    currentProcess = currentProcess.next; // move before removing current process
                    removeProcess(toRemove.pid);
                    if (tail == null) break; // all done
                } else {
                    currentProcess = currentProcess.next;
                }

                displayProcesses();
            } else {
                // If process burstTime is 0 (shouldn't be in list ideally), move on
                currentProcess = currentProcess.next;
            }
        }

        // Calculate average waiting and turnaround time
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

      
    }

    public static void main(String[] args) {
        RoundRobinCircularLinkedList rr = new RoundRobinCircularLinkedList();

        rr.addProcess(1, 10, 2);
        rr.addProcess(2, 5, 1);
        rr.addProcess(3, 8, 3);

        int timeQuantum = 3;

        System.out.println("Initial processes:");
        rr.displayProcesses();
        System.out.println("\nStarting Round Robin Scheduling (Time Quantum = " + timeQuantum + "):");
        rr.simulateRoundRobin(timeQuantum);
    }
}
