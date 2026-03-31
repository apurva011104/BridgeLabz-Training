import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class Library {
    
    private String libraryName;
    private final HashMap<String, LinkedList<Book>> bookGenre;
    private final HashSet<Book> booksRecord;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.bookGenre = new HashMap<>();
        this.booksRecord = new HashSet<>();
    }

    private boolean isBookPresent(String title, String author){
        for(Book book: booksRecord){
            if(title.equalsIgnoreCase(book.getTitle()) && author.equalsIgnoreCase(book.getAuthor())){
                return true;
            }
        }
        return false;
    }

    private boolean isBookIDUnique(String bookID){
        for(Book book: booksRecord){
            if(bookID.equals(book.getBookID())){
                return false;
            }
        }
        return true;
    }

    private String generateBookID(String title, String author){
        String bookId;
        do { 
            int hashcode = Objects.hash(title,author,(int)(Math.random()*100));
            bookId = "BOOK"+hashcode;
        } 
        while (!isBookIDUnique(bookId));
        return bookId;
    }


    /*------------------------CREATE OPERATIONS----------------------*/
    public void addBook(String title, String author, String genre){
        if(isBookPresent(title, author)){
            System.out.println("Book is already present in the library");
            return;
        }
        Book book = new Book(generateBookID(title, author), title, author);
        bookGenre.putIfAbsent(genre.toLowerCase(), new LinkedList<>());
        bookGenre.get(genre.toLowerCase()).add(book);
        booksRecord.add(book);
        System.out.println("Book added successfully");
    }

    /*--------------------------READ OPERATIONS-------------------------------*/
    public void printCatalog(){
        if(bookGenre.isEmpty()){
            System.out.println("Library catalog is empty");
            return;
        }
        System.out.println("*******************************************************");
        for(Map.Entry<String , LinkedList<Book>> entry : bookGenre.entrySet()){
            System.out.println("Genre: "+entry.getKey());
            LinkedList<Book> books = entry.getValue();
            if(books.isEmpty()){
                System.out.println("No books available");
                continue;
            }
            for(Book book: books){
                displayBookDetails(book);
            }
            System.out.println("*******************************************************");

        }
    }

    private void displayBookDetails(Book book){
        System.out.printf("Book ID: %s, Title: %s, Author: %s%n",book.getBookID(), book.getTitle(), book.getAuthor());
    }

    /*--------------------------UPDATE OPERATIONS-----------------------------*/
    public Book borrowBook(String title, String author) throws BookNotAvailableException{
        Book book=null;
        for(Book b: booksRecord){
            if(title.equalsIgnoreCase(b.getTitle()) && author.equalsIgnoreCase(b.getAuthor())){
                book=b;
                break;
            }
        }
        if(book==null){
            throw new BookNotAvailableException("No such book found in the record.");
        }
        if(!book.checkAvailability()){
            throw new BookNotAvailableException("Book is not available at the moment");
        }

        book.updateAvailability(false);
        System.out.println("Book borrowed successfully.");
        return book;
    }

    public void returnBook(Book book){
        if(!booksRecord.contains(book)){
            System.out.println("Book does not belong to the library");
            return;
        }
        book.updateAvailability(true);
        System.out.println("Book returned successfully");
    }

    /*--------------------------DELETE OPERATIONS-----------------------------*/
    public void removeBook(String title, String author) throws BookNotAvailableException{
        if(!isBookPresent(title, author)){
            throw new BookNotAvailableException("No such book found in the record.");
        }
        for(Map.Entry<String , LinkedList<Book>> entry : bookGenre.entrySet()){
            LinkedList<Book> books = entry.getValue();
            Iterator<Book> iterator = books.iterator();
            while(iterator.hasNext()){
                Book book = iterator.next();
                if(title.equalsIgnoreCase(book.getTitle()) &&
                   author.equalsIgnoreCase(book.getAuthor())){

                if(!book.checkAvailability()){
                    throw new BookNotAvailableException("Book is not available at the moment");
                }
                    iterator.remove();  
                    booksRecord.remove(book);
                    System.out.println("Book removed from library successfully");
                    return;
                }
            }
        }
    }
}
