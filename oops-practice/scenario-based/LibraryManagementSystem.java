import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

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

        //Getter and setters for book fields
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        //Method to update book status
        public void updateBookStatus(){
            this.status=status.equals("Available")?"Checked out":"Available";
        }
    }

    private String name;
    private ArrayList<Book> books;

    public LibraryManagementSystem(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    //Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Getter for books
    public ArrayList<Book> getBooks() {
        return books;
    }

    //Method to validate int input
    public static boolean validateIntegerInput(String num){
        try {
            int n= Integer.parseInt(num);
            if(n<=0){
                return false;
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    //Methods to take Integer input
    public static int takeIntegerInput(){
        String num=SCAN.nextLine();
        while(!validateIntegerInput(num)){
            System.out.print("Invalid input. Enter again: ");
            num = SCAN.nextLine();
        }
        return Integer.parseInt(num);
    }

    //Method to add book in library
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

    //Method to remove book from library
    public void removeBook(){
        System.out.print("Enter book title: ");
        String title = SCAN.nextLine();
        System.out.print("Enter author's name: ");
        String author = SCAN.nextLine();
        Book bookToRemove= findBookInLibrary(title, author);
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

    //Method to find the book among all of the books
    private Book findBookInLibrary(String title, String author){
        for(Book book: books){
            if(book.getTitle().toLowerCase().equals(title.toLowerCase()) && book.getAuthor().toLowerCase().equals(author.toLowerCase())){
                return book;
            }
        }
        return null;
    }
    
    //Method to search book by title
    private ArrayList<Book> findBooksWithTitle(String title){
        title=title.trim().toLowerCase();
        ArrayList<Book> booksFound = new ArrayList<>();
        for(Book book: books){
            if(book.getTitle().toLowerCase().contains(title)){
                booksFound.add(book);
            }
        }
        return booksFound;
    }


    //Method to search book by author
    private ArrayList<Book> findBooksWithAuthor(String author){
        author=author.trim().toLowerCase();
        ArrayList<Book> booksFound = new ArrayList<>();
        for(Book book: books){
            if(book.getAuthor().toLowerCase().contains(author)){
                booksFound.add(book);
            }
        }
        return booksFound;
    }

    //Method to check if user wants to search by book title or book author
    public void searchBook(){
        System.out.print("Do you want to search by book title or book author? Enter '1' for title or '2' for author: ");
        int userChoice = takeIntegerInput();
        while(userChoice>2){
            System.out.println("Invalid choice. Enter again: ");
            userChoice = takeIntegerInput();
        }
        ArrayList<Book> booksFound = new ArrayList<>();
        switch (userChoice){
            case 1:
                System.out.println("Enter book title: ");
                String title = SCAN.nextLine();
                booksFound = findBooksWithTitle(title);
                break;
            case 2:
                System.out.println("Enter name of author: ");
                String author = SCAN.nextLine();
                booksFound = findBooksWithAuthor(author);
                break;
            default:
                System.out.println("Invalid choice");
        }

        if(booksFound.size()==0){
            System.out.println("No book was found.");
            return;
        }
        for(int i=0 ; i<booksFound.size() ; i++){
            Book book= booksFound.get(i);
            System.out.printf("%d. Book title: %s, Author: %s, Status: %s%n",(i+1),book.getTitle(), book.getAuthor(), book.getStatus());
        }

    }

    //Method to display all of the books
    public void displayBooks(){
        for(int i=0 ; i<books.size() ; i++){
            Book book= books.get(i);
            System.out.printf("%d. Book title: %s, Author: %s, Status: %s%n",(i+1),book.getTitle(), book.getAuthor(), book.getStatus());
        }
    }

    //Method to checkout book
    private void checkoutBook(Book book){
        if(book.getStatus().equals("Checked Out")){
            System.out.println("Book is not available");
            return;
        }
        book.updateBookStatus();
        System.out.println("Book checked out successfully");
    }

    //Method to book checkout process
    public void checkout(){
        System.out.println("Enter title/partial title of the book you want to check out");
        String title = SCAN.nextLine();
        ArrayList<Book> foundBooks = findBooksWithTitle(title);
        if(foundBooks.size()==0){
            System.out.println("Sorry! No book was found with such title");
            return;
        }
        System.out.println("Books found in the library with similar title. Select one to check out: ");
        int userChoice=0;
        for(int i=0; i<foundBooks.size(); i++){
            Book book = foundBooks.get(i);
            System.out.println("Enter '"+(i+1)+"' for book \""+book.getTitle()+"\" by author "+book.getAuthor());
        }
        userChoice=takeIntegerInput()-1;
        while(userChoice<0 || userChoice>(foundBooks.size()-1)){
            System.out.print("Invalid choice. Enter choice again: ");
            userChoice=takeIntegerInput()-1;
        }
        checkoutBook(foundBooks.get(userChoice));  
    }


    //Method to take user or admin choices to perform operation as desired
    public void userChoiceOfOperations(){
        boolean flag = true;
        while(flag){
            System.out.print("Enter '1' if user wants to perform the operations or '2' if admin: ");
            int input = takeIntegerInput();
            while(input!=1 && input!=2){
                System.out.println("Please enter either '1' or '2': ");
                input=takeIntegerInput();
            }
            boolean isUser = input==1;
            System.out.println((isUser?"User":"Admin")+" will perform the operations.");
            if(isUser){
                System.out.println("Menu: ");
                System.out.println("Enter '1' for checking out a book");
                System.out.println("Enter '2' for searching books");
                System.out.println("Enter '3' for displaying all books");
                System.out.println("Enter '4' to exit the program");
                int userChoice = takeIntegerInput();
                while(userChoice<1 || userChoice>4){
                    System.out.print("Invalid choice. Enter again: ");
                    userChoice=takeIntegerInput();
                }
                switch (userChoice) {
                    case 1:
                        checkout();
                        break;
                    case 2:
                        searchBook();
                        break;
                    case 3:
                        displayBooks();
                        break;
                    default:
                        System.out.println("Exiting the program....");
                        flag = false;
                        
                }
            }
            else{
                System.out.println("Menu: ");
                System.out.println("Enter '1' for adding book");
                System.out.println("Enter '2' for removing book");
                System.out.println("Enter '3' for displaying all books");
                System.out.println("Enter '4' to exit the program");
                int adminChoice = takeIntegerInput();
                while(adminChoice<1 || adminChoice>4){
                    System.out.print("Invalid choice. Enter again: ");
                    adminChoice=takeIntegerInput();
                }
                switch (adminChoice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        removeBook();
                        break;
                    case 3:
                        displayBooks();
                        break;
                    default:
                        System.out.println("Exiting the program....");
                        flag = false;
                        
                }
            }
        }
    }
    
    //"main" method for testing
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem("Library of Global University");
        library.userChoiceOfOperations();
        SCAN.close();
    }
}
