package circularlinkedlist;

// Class representing a node in the circular linked list
class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    // Constructor to initialize the task node
    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// Class representing the circular linked list
class TaskCircularLinkedList {
    private TaskNode head;
    private TaskNode tail;
    private TaskNode current;

    // Add a task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // Circular linkage
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // Maintain circular linkage
        }
    }

    // Add a task at the end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (tail == null) {
            head = tail = newNode;
            tail.next = head; // Circular linkage
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular linkage
        }
    }

    // Add a task at a specific position
    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode temp = head;
        for (int i = 1; i < position - 1; i++) {
            if (temp == tail) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == tail) {
            tail = newNode;
        }
    }

    // Remove a task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.taskId == taskId) {
            if (head == tail) { // Single node case
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head; // Maintain circular linkage
            }
            System.out.println("Task removed successfully.");
            return;
        }
        TaskNode temp = head;
        while (temp.next != head && temp.next.taskId != taskId) {
            temp = temp.next;
        }
        if (temp.next == head) {
            System.out.println("Task not found.");
        } else {
            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
            System.out.println("Task removed successfully.");
        }
    }

    // View the current task and move to the next task
    public void viewAndMoveToNextTask() {
        if (current == null) {
            current = head;
        }
        if (current != null) {
            System.out.println("Current Task: ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next; // Move to the next task
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Display all tasks starting from the head
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode temp = head;
        System.out.println("Task List:");
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found: ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with the given priority.");
        }
    }
}

// Main class to test the Task Scheduler
 class TaskScheduler {
    public static void main(String[] args) {
        TaskCircularLinkedList taskList = new TaskCircularLinkedList();

        // Adding tasks
        taskList.addAtBeginning(1, "Design Project", 3, "2025-02-10");
        taskList.addAtEnd(2, "Code Review", 2, "2025-02-12");
        taskList.addAtPosition(2, 3, "Write Documentation", 1, "2025-02-11");

        // Display all tasks
        taskList.displayAllTasks();

        // View and move to the next task
        taskList.viewAndMoveToNextTask();
        taskList.viewAndMoveToNextTask();

        // Search for tasks by priority
        taskList.searchByPriority(2);

        // Remove a task by ID
        taskList.removeByTaskId(3);

        // Display all tasks after removal
        taskList.displayAllTasks();
    }
}

