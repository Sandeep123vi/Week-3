package doublylinkedlist2;

// Class representing a node in the singly linked list
class InventoryNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    InventoryNode next;

    // Constructor to initialize the inventory node
    public InventoryNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// Class representing the inventory management system
class InventoryManagementSystem {
    private InventoryNode head;

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        if (head == null) {
            head = newNode;
        } else {
            InventoryNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Add an item at a specific position
    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
        InventoryNode temp = head;
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

    // Remove an item based on Item ID
    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed successfully.");
            return;
        }
        InventoryNode temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed successfully.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantityByItemId(int itemId, int newQuantity) {
        InventoryNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search for an item by Item ID or Item Name
    public void searchItem(String itemName, int itemId) {
        InventoryNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemId == itemId || temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Found: Item Name: " + temp.itemName + ", Item ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // Calculate and display the total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        InventoryNode temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Sort inventory based on Item Name in ascending order
    public void sortByNameAscending() {
        if (head == null || head.next == null) {
            return;
        }
        for (InventoryNode i = head; i != null; i = i.next) {
            for (InventoryNode j = i.next; j != null; j = j.next) {
                if (i.itemName.compareToIgnoreCase(j.itemName) > 0) {
                    swapNodes(i, j);
                }
            }
        }
        System.out.println("Inventory sorted by Item Name in ascending order.");
    }

    // Sort inventory based on Price in descending order
    public void sortByPriceDescending() {
        if (head == null || head.next == null) {
            return;
        }
        for (InventoryNode i = head; i != null; i = i.next) {
            for (InventoryNode j = i.next; j != null; j = j.next) {
                if (i.price < j.price) {
                    swapNodes(i, j);
                }
            }
        }
        System.out.println("Inventory sorted by Price in descending order.");
    }

    // Helper method to swap two nodes
    private void swapNodes(InventoryNode node1, InventoryNode node2) {
        String tempName = node1.itemName;
        int tempId = node1.itemId;
        int tempQuantity = node1.quantity;
        double tempPrice = node1.price;

        node1.itemName = node2.itemName;
        node1.itemId = node2.itemId;
        node1.quantity = node2.quantity;
        node1.price = node2.price;

        node2.itemName = tempName;
        node2.itemId = tempId;
        node2.quantity = tempQuantity;
        node2.price = tempPrice;
    }

    // Display all items in the inventory
    public void displayAllItems() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        InventoryNode temp = head;
        System.out.println("Inventory List:");
        while (temp != null) {
            System.out.println("Item Name: " + temp.itemName + ", Item ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

// Main class to test the Inventory Management System
 class LibraryManagementSystem {
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        // Adding items
        inventory.addAtBeginning("Laptop", 101, 5, 75000);
        inventory.addAtEnd("Phone", 102, 10, 50000);
        inventory.addAtPosition(2, "Tablet", 103, 7, 30000);

        // Display all items
        inventory.displayAllItems();

        // Update quantity
        inventory.updateQuantityByItemId(102, 12);

        // Search for an item
        inventory.searchItem("Laptop", 0);
        inventory.searchItem("", 103);

        // Calculate total inventory value
        inventory.calculateTotalValue();

        // Sort inventory
        inventory.sortByNameAscending();
        inventory.displayAllItems();

        inventory.sortByPriceDescending();
        inventory.displayAllItems();

        // Remove an item
        inventory.removeByItemId(103);
        inventory.displayAllItems();
    }
}
