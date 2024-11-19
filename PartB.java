
// Book.java
public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;  // By default, the book is not borrowed
    }

    // Getter and Setter Methods
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    // Method to display book details
    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (isBorrowed ? "No" : "Yes"));
    }
}

// ReferenceBook.java
public class ReferenceBook extends Book {
    private int edition;

    public ReferenceBook(int bookId, String title, String author, int edition) {
        super(bookId, title, author);
        this.edition = edition;
    }

    // Getter and Setter Methods
    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Edition: " + edition);
    }
}

// FictionBook.java
public class FictionBook extends Book {
    private String genre;

    public FictionBook(int bookId, String title, String author, String genre) {
        super(bookId, title, author);
        this.genre = genre;
    }

    // Getter and Setter Methods
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Genre: " + genre);
    }
}

// Periodical.java
public class Periodical extends ReferenceBook {
    private String issueFrequency;

    public Periodical(int bookId, String title, String author, int edition, String issueFrequency) {
        super(bookId, title, author, edition);
        this.issueFrequency = issueFrequency;
    }

    // Getter and Setter Methods
    public String getIssueFrequency() {
        return issueFrequency;
    }

    public void setIssueFrequency(String issueFrequency) {
        this.issueFrequency = issueFrequency;
    }

    @Override
    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Issue Frequency: " + issueFrequency);
    }
}

// Library.java
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId && !book.isBorrowed()) {
                book.setBorrowed(true);
                System.out.println("You have borrowed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book is either unavailable or already borrowed.");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId && book.isBorrowed()) {
                book.setBorrowed(false);
                System.out.println("You have returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("This book was not borrowed.");
    }

    public void displayLibraryBooks() {
        for (Book book : books) {
            book.displayBookInfo();
            System.out.println("-------------");
        }
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create books
        Book book1 = new FictionBook(1, "The Alchemist", "Paulo Coelho", "Adventure");
        Book book2 = new ReferenceBook(2, "Java Programming", "Herbert Schildt", 10);
        Book book3 = new Periodical(3, "Tech Monthly", "Various", 5, "Monthly");

        // Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Display library books
        System.out.println("Library Books:");
        library.displayLibraryBooks();

        // Borrowing and returning books
        library.borrowBook(1);  // Borrow the first book
        library.returnBook(1);  // Return the first book
    }
}
