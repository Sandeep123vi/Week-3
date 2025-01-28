package doublylinkedlist3;

// Class representing a node in the doubly linked list
class TextStateNode {
    String textContent; // The state of the text
    TextStateNode prev;
    TextStateNode next;

    // Constructor to initialize a text state node
    public TextStateNode(String textContent) {
        this.textContent = textContent;
        this.prev = null;
        this.next = null;
    }
}

// Class implementing the undo/redo functionality for a text editor
class TextEditor {
    private TextStateNode head;
    private TextStateNode tail;
    private TextStateNode currentState;
    private int maxHistorySize;
    private int currentSize;

    // Constructor to initialize the text editor with a history limit
    public TextEditor(int maxHistorySize) {
        this.maxHistorySize = maxHistorySize;
        this.currentSize = 0;
        this.head = null;
        this.tail = null;
        this.currentState = null;
    }

    // Add a new state to the text editor
    public void addState(String textContent) {
        TextStateNode newState = new TextStateNode(textContent);

        // If the list is empty, initialize it
        if (head == null) {
            head = tail = currentState = newState;
        } else {
            // Remove forward redo history if present
            currentState.next = null;
            tail = currentState;

            // Add the new state to the end
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            currentState = newState;

            // Increment size and check if it exceeds max history size
            currentSize++;
            if (currentSize > maxHistorySize) {
                // Remove the oldest state (head)
                head = head.next;
                head.prev = null;
                currentSize--;
            }
        }
        System.out.println("New state added: " + textContent);
    }

    // Undo functionality
    public void undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("No more states to undo.");
            return;
        }
        currentState = currentState.prev;
        System.out.println("Undo performed. Current state: " + currentState.textContent);
    }

    // Redo functionality
    public void redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("No more states to redo.");
            return;
        }
        currentState = currentState.next;
        System.out.println("Redo performed. Current state: " + currentState.textContent);
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (currentState == null) {
            System.out.println("No current state available.");
        } else {
            System.out.println("Current state: " + currentState.textContent);
        }
    }
}

// Main class to demonstrate the undo/redo functionality
 class UndoRedoFunctionality {
    public static void main(String[] args) {
        // Initialize the text editor with a history size of 10
        TextEditor editor = new TextEditor(10);

        // Simulate adding text states
        editor.addState("State 1: Hello");
        editor.addState("State 2: Hello World");
        editor.addState("State 3: Hello World!");

        // Display current state
        editor.displayCurrentState();

        // Perform undo operations
        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        // Perform redo operations
        editor.redo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        // Add new states to simulate history management
        editor.addState("State 4: Welcome to the text editor");
        editor.addState("State 5: Undo/Redo functionality implemented");

        // Undo and redo to test limits
        editor.undo();
        editor.undo();
        editor.redo();
    }
}
