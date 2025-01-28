package doublylinkedlist;

// Class representing a node in the doubly linked list
class MovieNode {
    String title;
    String director;
    int yearOfRelease;
    double rating;
    MovieNode next;
    MovieNode prev;

    // Constructor to initialize the movie node
    public MovieNode(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

// Class representing the doubly linked list
class MovieLinkedList {
    private MovieNode head;
    private MovieNode tail;

    // Add a movie record at the beginning
    public void addAtBeginning(String title, String director, int yearOfRelease, double rating) {
        MovieNode newNode = new MovieNode(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a movie record at the end
    public void addAtEnd(String title, String director, int yearOfRelease, double rating) {
        MovieNode newNode = new MovieNode(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a movie record at a specific position
    public void addAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(title, director, yearOfRelease, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, yearOfRelease, rating);
        MovieNode temp = head;
        for (int i = 1; i < position - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }
        if (temp == tail) {
            addAtEnd(title, director, yearOfRelease, rating);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    // Remove a movie record by Movie Title
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }
        if (temp == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        System.out.println("Movie removed successfully.");
    }

    // Search for a movie record by Director or Rating
    public void searchByDirectorOrRating(String director, double rating) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director) || temp.rating == rating) {
                System.out.println("Found: Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No matching movie found.");
        }
    }

    // Display all movie records in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies found.");
            return;
        }
        MovieNode temp = head;
        System.out.println("Movies in Forward Order:");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display all movie records in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies found.");
            return;
        }
        MovieNode temp = tail;
        System.out.println("Movies in Reverse Order:");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update a movie's Rating based on the Movie Title
    public void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }
}

// Main class to test the Movie Management System
 class MovieManagement {
    public static void main(String[] args) {
        MovieLinkedList movieList = new MovieLinkedList();

        // Adding movies
        movieList.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.addAtPosition(2, "The Dark Knight", "Christopher Nolan", 2008, 9.0);

        // Display movies
        movieList.displayForward();

        // Search by director or rating
        movieList.searchByDirectorOrRating("Christopher Nolan", 8.8);

        // Update a movie's rating
        movieList.updateRating("Inception", 9.0);

        // Display movies in reverse order
        movieList.displayReverse();

        // Remove a movie by title
        movieList.removeByTitle("Interstellar");

        // Display movies after deletion
        movieList.displayForward();
    }
}
