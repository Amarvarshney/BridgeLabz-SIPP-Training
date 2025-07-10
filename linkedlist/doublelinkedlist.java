package linkedlist;
class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode prev;
    MovieNode next;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

public class doublelinkedlist {
    private MovieNode head;
    private MovieNode tail;

    // Add movie at the beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add movie at the end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add movie at a specific position (1-based index)
    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode current = head;
        int index = 1;

        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }

        current.next = newNode;
    }

    // Remove movie by title
    public void removeByTitle(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                System.out.println("Removed movie: " + title);
                return;
            }
            current = current.next;
        }

        System.out.println("Movie not found: " + title);
    }

    // Search by director
    public void searchByDirector(String director) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found by this director.");
        }
    }

    // Search by rating
    public void searchByRating(double rating) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.rating == rating) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with this rating.");
        }
    }

    // Update rating by title
    public void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Updated rating for: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    // Display all movies forward
    public void displayForward() {
        MovieNode current = head;
        if (current == null) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("Movies in forward order:");
        while (current != null) {
            printMovie(current);
            current = current.next;
        }
    }

    // Display all movies in reverse
    public void displayReverse() {
        MovieNode current = tail;
        if (current == null) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("Movies in reverse order:");
        while (current != null) {
            printMovie(current);
            current = current.prev;
        }
    }

    // Utility: Print a movie node
    private void printMovie(MovieNode node) {
        System.out.println("Title: " + node.title +
                           ", Director: " + node.director +
                           ", Year: " + node.year +
                           ", Rating: " + node.rating);
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        doublelinkedlist mms = new doublelinkedlist();

        mms.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        mms.addAtBeginning("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        mms.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        mms.addAtPosition("Pulp Fiction", "Quentin Tarantino", 1994, 8.9, 2);

        mms.displayForward();
        mms.displayReverse();

        mms.searchByDirector("Christopher Nolan");
        mms.searchByRating(8.9);

        mms.updateRating("Interstellar", 9.0);
        mms.removeByTitle("The Godfather");

        mms.displayForward();
    }
}
