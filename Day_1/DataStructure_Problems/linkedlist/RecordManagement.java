package linkedlist;
// Class representing a node in the singly linked list
class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    // Constructor to initialize the student node
    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Class representing the singly linked list
class StudentLinkedList {
    private StudentNode head;

    // Add a new student record at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add a new student record at the end
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add a new student record at a specific position
    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        StudentNode temp = head;
        for (int i = 1; i < position - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete a student record by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Record deleted successfully.");
            return;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Record not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Record deleted successfully.");
        }
    }

    // Search for a student record by Roll Number
    public void searchByRollNumber(int rollNumber) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Record Found: Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Record not found.");
    }

    // Update a student's grade based on their Roll Number
    public void updateGrade(int rollNumber, String newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Record not found.");
    }

    // Display all student records
    public void displayAllRecords() {
        if (head == null) {
            System.out.println("No records found.");
            return;
        }
        StudentNode temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

// Main class to test the Student Record Management System
class RecordManagement  {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();

        // Adding student records
        studentList.addAtBeginning(1, "John", 20, "A");
        studentList.addAtEnd(2, "Alice", 19, "B");
        studentList.addAtPosition(2, 3, "Bob", 21, "C");

        // Displaying all student records
        studentList.displayAllRecords();

        // Searching for a student record
        studentList.searchByRollNumber(2);

        // Updating a student's grade
        studentList.updateGrade(3, "A+");

        // Displaying all records after updating
        studentList.displayAllRecords();

        // Deleting a student record
        studentList.deleteByRollNumber(1);

        // Displaying all records after deletion
        studentList.displayAllRecords();
    }
}
