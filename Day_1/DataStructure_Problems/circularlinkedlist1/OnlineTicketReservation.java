package circularlinkedlist1;
// Class representing a node in the circular linked list
class TicketNode {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    // Constructor to initialize a ticket node
    public TicketNode(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

// Class implementing the ticket reservation system
class TicketReservationSystem {
    private TicketNode head;

    // Constructor to initialize the reservation system
    public TicketReservationSystem() {
        this.head = null;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newTicket;
            newTicket.next = head; // Circular reference
        } else {
            TicketNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head; // Maintain circular structure
        }
        System.out.println("Ticket added successfully: " + ticketID);
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        TicketNode current = head;
        TicketNode prev = null;

        // Find the ticket to remove
        do {
            if (current.ticketID == ticketID) {
                if (prev == null) { // Removing head
                    if (current.next == head) { // Only one ticket
                        head = null;
                    } else {
                        TicketNode temp = head;
                        while (temp.next != head) {
                            temp = temp.next;
                        }
                        head = current.next;
                        temp.next = head;
                    }
                } else {
                    prev.next = current.next;
                }
                System.out.println("Ticket removed successfully: " + ticketID);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket ID not found: " + ticketID);
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets to display.");
            return;
        }

        TicketNode temp = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer Name: " + temp.customerName + ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (head == null) {
            System.out.println("No tickets available to search.");
            return;
        }

        TicketNode temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket Found: Ticket ID: " + temp.ticketID + ", Customer Name: " + temp.customerName + ", Movie Name: " + temp.movieName + ", Seat Number: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tickets found for query: " + query);
        }
    }

    // Calculate the total number of booked tickets
    public int countTickets() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}

// Main class to demonstrate the ticket reservation system
class OnlineTicketReservation {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Add tickets
        system.addTicket(1, "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket(2, "Bob", "Inception", "A2", "10:00 AM");
        system.addTicket(3, "Charlie", "Avatar", "B1", "12:00 PM");

        // Display tickets
        system.displayTickets();

        // Search for a ticket
        system.searchTicket("Inception");

        // Remove a ticket
        system.removeTicket(2);
        system.displayTickets();

        // Count tickets
        System.out.println("Total Tickets: " + system.countTickets());
    }
}