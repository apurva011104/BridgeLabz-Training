import java.util.ArrayList;
import java.util.Scanner;

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

public class LibraryManagementSystem2 {

    private static final Scanner SCAN = new Scanner(System.in);

    class Book{
        private String title;
        private String author;
        private String status;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.status = "Available";
        }

        public void displayDetails(){
            System.out.println("Book title: "+title);
            System.out.println("Book author: "+author);
            System.out.println("Book status: "+status);
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getStatus() {
            return status;
        }

        public void updateBookStatus(){
            this.status = status.equals("Available") ? "Checked Out" : "Available";
        }
    }

    private String name;
    private ArrayList<Book> books;

    public LibraryManagementSystem2(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public static boolean validateIntegerInput(String num){
        try {
            int n = Integer.parseInt(num);
            return n > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static int takeIntegerInput(){
        String num = SCAN.nextLine();
        while(!validateIntegerInput(num)){
            System.out.print("Invalid input. Enter again: ");
            num = SCAN.nextLine();
        }
        return Integer.parseInt(num);
    }

    public void addBook(){
        System.out.print("Enter book title: ");
        String title = SCAN.nextLine();
        System.out.print("Enter author's name: ");
        String author = SCAN.nextLine();

        if(findBookInLibrary(title, author)!=null){
            System.out.println("Book has already been added in the library");
            return;
        }
        books.add(new Book(title, author));
        System.out.println("Book added successfully");
    }

    public void removeBook(){
        System.out.print("Enter book title: ");
        String title = SCAN.nextLine();
        System.out.print("Enter author's name: ");
        String author = SCAN.nextLine();

        Book bookToRemove = findBookInLibrary(title, author);
        if(bookToRemove==null){
            System.out.println("No such book to remove was found in the library");
            return;
        }
        if(bookToRemove.getStatus().equals("Checked Out")){
            System.out.println("The book to be removed is not available in the library. Wait for it to be returned.");
            return;
        }
        books.remove(bookToRemove);
        System.out.println("Book removed from library successfully");
    }

    private Book findBookInLibrary(String title, String author){
        for(Book book: books){
            if(book.getTitle().equalsIgnoreCase(title)
                && book.getAuthor().equalsIgnoreCase(author)){
                return book;
            }
        }
        return null;
    }

    private ArrayList<Book> findBooksWithTitle(String title){
        ArrayList<Book> booksFound = new ArrayList<>();
        title = title.toLowerCase();
        for(Book book: books){
            if(book.getTitle().toLowerCase().contains(title)){
                booksFound.add(book);
            }
        }
        return booksFound;
    }

    public void searchBook(){
        System.out.print("Enter '1' for title or '2' for author: ");
        int userChoice = takeIntegerInput();

        ArrayList<Book> booksFound = new ArrayList<>();
        if(userChoice == 1){
            System.out.print("Enter book title: ");
            booksFound = findBooksWithTitle(SCAN.nextLine());
        }

        if(booksFound.size()==0){
            System.out.println("No book was found.");
            return;
        }

        for(int i=0;i<booksFound.size();i++){
            Book b = booksFound.get(i);
            System.out.printf("%d. %s | %s | %s%n",
                    i+1, b.getTitle(), b.getAuthor(), b.getStatus());
        }
    }

    public void displayBooks(){
        for(int i=0;i<books.size();i++){
            Book b = books.get(i);
            System.out.printf("%d. %s | %s | %s%n",
                    i+1, b.getTitle(), b.getAuthor(), b.getStatus());
        }
    }

    private void checkoutBook(Book book) throws BookNotAvailableException {
        if(book.getStatus().equals("Checked Out")){
            throw new BookNotAvailableException("Book is already checked out.");
        }
        book.updateBookStatus();
        System.out.println("Book checked out successfully");
    }

    public void checkout(){
        System.out.print("Enter title/partial title of the book: ");
        String title = SCAN.nextLine();

        ArrayList<Book> foundBooks = findBooksWithTitle(title);
        if(foundBooks.size()==0){
            System.out.println("Sorry! No book was found with such title");
            return;
        }

        for(int i=0;i<foundBooks.size();i++){
            Book b = foundBooks.get(i);
            System.out.println((i+1)+". "+b.getTitle()+" by "+b.getAuthor());
        }

        int choice = takeIntegerInput() - 1;
        try {
            checkoutBook(foundBooks.get(choice));
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }

    public void userChoiceOfOperations(){
        boolean flag = true;
        while(flag){
            System.out.print("Enter '1' for user or '2' for admin: ");
            int input = takeIntegerInput();

            if(input == 1){
                System.out.println("1.Checkout  2.Search  3.Display  4.Exit");
                int choice = takeIntegerInput();
                switch(choice){
                    case 1 -> checkout();
                    case 2 -> searchBook();
                    case 3 -> displayBooks();
                    default -> flag = false;
                }
            } else {
                System.out.println("1.Add  2.Remove  3.Display  4.Exit");
                int choice = takeIntegerInput();
                switch(choice){
                    case 1 -> addBook();
                    case 2 -> removeBook();
                    case 3 -> displayBooks();
                    default -> flag = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem2 library = new LibraryManagementSystem2("Library of Global University");
        library.userChoiceOfOperations();
        SCAN.close();
    }
}
