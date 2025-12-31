public class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    public void borrowBook(){
        if(!isAvailable){
            System.out.println("Book not available");
        }
        else{
            isAvailable = false;
            System.out.println("Book borrowed successfully");
        }
    }

    public void bookDetails(){
        System.out.println("---------------------------------------------------------");
        System.out.println("Book title: "+title);
        System.out.println("Book author: "+author);
        System.out.printf("Book price: %.2f%n",price);
        System.out.println("Availability: "+(isAvailable?"Available":"Not available"));
        System.out.println("--------------------------------------------------------");
    }

    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("Crime And Punishment", "Fyodor Dostoevsky", 400);
        book1.bookDetails();
        book1.borrowBook();
        book1.bookDetails();
        book1.borrowBook();
    }
    
}
