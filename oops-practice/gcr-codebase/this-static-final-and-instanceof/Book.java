public class Book {
    
    //Static variable
    private static String libraryName = "Egmore Library";

    //Instance variables
    private final String isbn;      //Final variable
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    //Getters and setters
    public String getISBN(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }

    //Static method to print library name
    public static void displayLibraryName(){
        System.out.println("Library Name: "+libraryName);
    }

    //Instance method to display book details
    public void displayBookDetails(){
        if(this instanceof Book){
            displayLibraryName();
            System.out.println("Title: "+title);
            System.out.println("Author: "+author);
            System.out.println("ISBN: "+isbn);
        }
        else{
            System.out.println("Invalid book instance");
        }
    }

    public static void main(String[] args) {
        
        Book book1 = new Book("978-0134685991","Effective Java","Joshua Bloch");
        book1.displayBookDetails();
    }

}
