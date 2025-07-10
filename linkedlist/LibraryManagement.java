package linkedlist;

class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;

    BookNode prev;
    BookNode next;

    public BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}

public class LibraryManagement {
    private BookNode head = null;
    private BookNode tail = null;

    // Add at beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add at end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add at specific position (1-based)
    public void addAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        BookNode temp = head;
        int index = 1;

        while (temp != null && index < position - 1) {
            temp = temp.next;
            index++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, bookId, isAvailable);
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Remove by Book ID
    public void removeById(int bookId) {
        BookNode current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;

                if (current.next != null) current.next.prev = current.prev;
                else tail = current.prev;

                System.out.println("Book with ID " + bookId + " removed.");
                return;
            }
            current = current.next;
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Search by Title
    public void searchByTitle(String title) {
        BookNode current = head;
        boolean found = false;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                printBook(current);
                found = true;
            }
            current = current.next;
        }

        if (!found) System.out.println("No book found with title: " + title);
    }

    // Search by Author
    public void searchByAuthor(String author) {
        BookNode current = head;
        boolean found = false;

        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                printBook(current);
                found = true;
            }
            current = current.next;
        }

        if (!found) System.out.println("No books found by author: " + author);
    }

    // Update Availability Status
    public void updateAvailability(int bookId, boolean status) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = status;
                System.out.println("Availability updated for book ID " + bookId);
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display books in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode current = head;
        System.out.println("Books in Library (Forward):");
        while (current != null) {
            printBook(current);
            current = current.next;
        }
    }

    // Display books in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode current = tail;
        System.out.println("Books in Library (Reverse):");
        while (current != null) {
            printBook(current);
            current = current.prev;
        }
    }

    // Count total books
    public void countBooks() {
        int count = 0;
        BookNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Total number of books: " + count);
    }

    // Helper: print a book
    private void printBook(BookNode book) {
        System.out.printf("ID: %d | Title: %s | Author: %s | Genre: %s | Available: %s\n",
                book.bookId, book.title, book.author, book.genre, book.isAvailable ? "Yes" : "No");
    }

    // Main method to test
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        library.addAtEnd("1984", "George Orwell", "Dystopian", 101, true);
        library.addAtBeginning("Pride and Prejudice", "Jane Austen", "Romance", 102, true);
        library.addAtPosition("To Kill a Mockingbird", "Harper Lee", "Fiction", 103, false, 2);
        library.addAtEnd("Moby Dick", "Herman Melville", "Adventure", 104, true);

        library.displayForward();
        library.displayReverse();

        library.searchByTitle("1984");
        library.searchByAuthor("Harper Lee");

        library.updateAvailability(103, true);
        library.removeById(104);

        library.displayForward();
        library.countBooks();
    }
}
