import java.util.ArrayList;

public class LibraryManagement {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();

        // Add books to the catalog
        catalog.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));

        // Search for a book by title
        catalog.searchByTitle("The Great Gatsby");

        // Check out a book
        catalog.checkOutBook("The Great Gatsby");

        // Return a book
        catalog.returnBook("The Great Gatsby");

        // Search for books by author
        catalog.searchByAuthor("Harper Lee");

    }
}

class LibraryCatalog {
    private ArrayList<Book> books;

    // Constructor
    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the catalog
    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " has been added to the catalog.");
    }

    // Method to search for books by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with the title: " + title);
        }
    }

    // Method to search for books by author
    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by the author: " + author);
        }
    }

    // Method to check out a book
    public void checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.checkOut();
                return;
            }
        }
        System.out.println("No book found with the title: " + title);
    }

    // Method to return a book
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("No book found with the title: " + title);
    }
}

class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false; // Initially, the book is available
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    // Methods to check out and return the book
    public void checkOut() {
        if (!isCheckedOut) {
            isCheckedOut = true;
            System.out.println(title + " has been checked out.");
        } else {
            System.out.println(title + " is already checked out.");
        }
    }

    public void returnBook() {
        if (isCheckedOut) {
            isCheckedOut = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not checked out.");
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Status: " + (isCheckedOut ? "Checked Out" : "Available");
    }
}
