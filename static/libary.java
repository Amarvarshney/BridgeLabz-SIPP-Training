public class libary {
    static String libraryName = "City Library";
    final String isbn;
    String title, author;

    libary(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    void displayDetails() {
        if (this instanceof libary) {
            System.out.println("Title: " + title+"\nAuthor: " + author + ", ISBN: " + isbn);
        }
    }
    public static void main(String[] args) {
        libary a=new libary("comcie","amar", "king");
        a.displayLibraryName();
        a.displayDetails();
    }
}
