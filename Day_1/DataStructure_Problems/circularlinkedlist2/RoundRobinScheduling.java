package circularlinkedlist2;
// Class representing a process in the circular linked list
class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    ProcessNode next;

    // Constructor to initialize a process node
    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

// Class implementing the Round Robin Scheduling Algorithm
class RoundRobinScheduler {
    private ProcessNode head;
    private ProcessNode tail;

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular nature
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        ProcessNode current = head;
        ProcessNode previous = tail;
        do {
            if (current.processId == processId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }
                if (current == tail) {
                    tail = previous;
                }
                System.out.println("Process " + processId + " removed from the queue.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate the scheduling of processes in a round-robin manner
    public void simulateScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        System.out.println("Simulating Round Robin Scheduling...");
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int processCount = 0;

        ProcessNode current = head;
        while (true) {
            boolean allProcessesCompleted = true;
            ProcessNode temp = head;

            do {
                if (temp.burstTime > 0) {
                    allProcessesCompleted = false;
                    int executionTime = Math.min(temp.burstTime, timeQuantum);
                    System.out.println("Executing Process ID: " + temp.processId + " for " + executionTime + " units.");
                    temp.burstTime -= executionTime;

                    if (temp.burstTime == 0) {
                        System.out.println("Process ID: " + temp.processId + " completed.");
                        totalTurnaroundTime += executionTime + totalWaitingTime;
                        removeProcess(temp.processId);
                        processCount++;
                    }
                }

                temp = temp.next;
            } while (temp != head);

            if (allProcessesCompleted) {
                break;
            }
        }

        // Calculate average waiting time and turnaround time
        double averageWaitingTime = (double) totalWaitingTime / processCount;
        double averageTurnaroundTime = (double) totalTurnaroundTime / processCount;

        System.out.println("Average Waiting Time: " + averageWaitingTime);
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime);
    }

    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        System.out.println("Processes in the queue:");
        ProcessNode temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

// Main class to demonstrate the Round Robin Scheduling Algorithm
 class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Add processes to the scheduler
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        // Display the processes
        scheduler.displayProcesses();

        // Simulate scheduling with a time quantum of 4
        scheduler.simulateScheduling(4);
    }
}
