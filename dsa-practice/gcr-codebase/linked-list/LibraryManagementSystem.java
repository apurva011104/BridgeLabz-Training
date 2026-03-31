import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Book {
    private final String bookId;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(String bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
    }

    public String getBookId() { 
        return bookId; 
    }

    public String getTitle() { 
        return title;
    }

    public String getAuthor() {
        return author; 
    }

    public String getGenre() {
        return genre; 
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean available) {
        this.isAvailable = available;
    }

    public void displayBook() {
        System.out.printf("Book ID: %s, Title: %s, Author: %s, Genre: %s, Available: %s%n",bookId, title, author, genre, isAvailable ? "Yes" : "No");
    }
}

class BookNode {

    private Book book;
    private BookNode next;
    private BookNode previous;

    public BookNode(Book book) {
        this.book = book;
    }

    public Book getBook() { 
        return book; 
    }

    public BookNode getNext() {
        return next;
    }

    public BookNode getPrevious() {
        return previous;
    }
    
    public void setNext(BookNode next) {
        this.next = next;
    }

    public void setPrevious(BookNode previous) {
        this.previous = previous;
    }

}

public class LibraryManagementSystem {

    private Set<String> allBookIDs;
    private BookNode bookHead;
    private BookNode bookTail;
    

    public LibraryManagementSystem() {
        allBookIDs = new HashSet<>();
    }

    private boolean bookExists(String bookId) {
        return allBookIDs.contains(bookId);
    }

    public int size() {
        return allBookIDs.size();
    }

    /*-----------------------------CREATE OPERATIONS----------------------------*/

    public void addBookAtTheBeginning(String bookId, String title, String author, String genre, boolean isAvailable) {
        
        if (bookExists(bookId)) {
            System.out.println("Book ID already exists");
            return;
        }

        Book book = new Book(bookId, title, author, genre, isAvailable);
        BookNode bookNode = new BookNode(book);

        if (bookHead == null) { 
            bookHead = bookNode;
            bookTail = bookNode;
        } 
        else {
            bookNode.setNext(bookHead);
            bookHead.setPrevious(bookNode);
            bookHead = bookNode;
        }

        allBookIDs.add(bookId);
        System.out.println("Book added successfully");
    }

    public void addBookAtTheEnd(String bookId, String title, String author, String genre, boolean isAvailable) {
        if (bookExists(bookId)) {
            System.out.println("Book ID already exists");
            return;
        }

        Book book = new Book(bookId, title, author, genre, isAvailable);
        BookNode bookNode = new BookNode(book);

        if (bookTail == null) {
            bookHead = bookNode;
            bookTail = bookNode;
        } 
        else {
            bookTail.setNext(bookNode);
            bookNode.setPrevious(bookTail);
            bookTail = bookNode;
        }

        allBookIDs.add(bookId);
        System.out.println("Book added successfully");
    }

    public void addBookAtPosition(String bookId, String title, String author, String genre, boolean isAvailable, int position) {
        int size = size();

        if (position < 0 || position > size) {
            System.out.println("Not a valid position");
            return;
        }

        if (position == 0) {
            addBookAtTheBeginning(bookId, title, author, genre, isAvailable);
        } 
        else if (position == size) {
            addBookAtTheEnd(bookId, title, author, genre, isAvailable);
        } 
        else {

            Book book = new Book(bookId, title, author, genre, isAvailable);
            BookNode bookNode = new BookNode(book);

            BookNode current = bookHead;

            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }

            bookNode.setNext(current.getNext());
            bookNode.setPrevious(current);
            current.getNext().setPrevious(bookNode);
            current.setNext(bookNode);

            allBookIDs.add(bookId);
            System.out.println("Book added successfully");
        }
    }

    /*-------------------------------READ OPERATIONS---------------------------*/

    public int countBooks() {
        return size();
    }

    public void displayAllBooksForward() {
        if (bookHead == null) {
            System.out.println("Library is empty");
            return;
        }
        BookNode current = bookHead;

        System.out.println("All books (forward display):");
        
        while (current != null) {
            current.getBook().displayBook();
            current = current.getNext();
        }
    }

    public void displayAllBooksReverse() {
        if (bookHead == null) {
            System.out.println("Library is empty");
            return;
        }
        BookNode current = bookTail;
        System.out.println("All books (reverse display):");
        while (current != null) {
            current.getBook().displayBook();
            current = current.getPrevious();
        }
    }

    public void searchBookByTitle(String title) {
        BookNode current = bookHead;
        ArrayList<BookNode> foundBooks = new ArrayList<>();
        while (current != null) {
            if (current.getBook().getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(current);
            }
            current = current.getNext();
        }

        if (foundBooks.isEmpty()) {
            System.out.println("No such book found");
        } 
        else {
            System.out.println("Book(s) found: ");
            for (BookNode book : foundBooks) {
                book.getBook().displayBook();
            }
        }
    }

    public void searchBookByAuthor(String author) {
        BookNode current = bookHead;
        ArrayList<BookNode> foundBooks = new ArrayList<>();
        while (current != null) {
            if (current.getBook().getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(current);
            }
            current = current.getNext();
        }

        if (foundBooks.isEmpty()) {
            System.out.println("No such book found.");
        } 
        else {
            System.out.println("Book(s) found: ");
            for (BookNode book : foundBooks) {
                book.getBook().displayBook();
            }
        }
    }

    /*---------------------------------UPDATE OPERATIONS---------------------------------*/

    public void updateAvailability(String bookId, boolean newStatus) {
        if (!bookExists(bookId)) {
            System.out.println("No such book exists");
            return;
        }

        BookNode current = bookHead;
        while (current != null) {
            if (current.getBook().getBookId().equals(bookId)) {
                current.getBook().setAvailability(newStatus);
                System.out.println("Availability updated successfully");
                return;
            }
            current = current.getNext();
        }
    }

    /*----------------------------------DELETE OPERATIONS-------------------------------*/

    public void removeBook(String bookId) {
        if (!bookExists(bookId)) {
            System.out.println("No such book exists");
            return;
        }

        BookNode current = bookHead;

        if (bookHead.getBook().getBookId().equals(bookId)) {
            bookHead = bookHead.getNext();
            if (bookHead != null) {
                bookHead.setPrevious(null);
            } 
            else {
                bookTail = null; 
            }
        } 
        else {
            while (current != null && !current.getBook().getBookId().equals(bookId)) {
                current = current.getNext();
            }

            if (current != null) {
                if (current.getNext() != null) {
                    current.getNext().setPrevious(current.getPrevious());
                } 
                else {
                    bookTail = current.getPrevious(); 
                }

                if (current.getPrevious() != null) {
                    current.getPrevious().setNext(current.getNext());
                }
            }
        }

        allBookIDs.remove(bookId);
        System.out.println("Book removed successfully");
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBookAtTheBeginning("B4794", "Art of Silence", "Lucy", "Psychology", true);
        library.addBookAtTheEnd("B4545", "Crystal", "Ruby", "Fantasy", true);
        library.addBookAtTheEnd("B5152", "Pluto", "Jane", "Sci-Fi", true);
        library.addBookAtTheBeginning("B7894", "Wonderland", "Ruby", "Fantasy", true);
        library.addBookAtPosition("B3472", "Barbie Dreamland", "Ava", "Kids", true, 2);

        System.out.println("Total number of books: " + library.countBooks());
        library.displayAllBooksForward();

        library.searchBookByTitle("Pluto");
        library.searchBookByAuthor("Ruby");

        library.updateAvailability("B4545", false);
        library.displayAllBooksForward();

        library.removeBook("B5152");

        library.displayAllBooksReverse();

        System.out.println("Total number of books: " + library.countBooks());
    }
}
