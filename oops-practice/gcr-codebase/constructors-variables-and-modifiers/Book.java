public class Book {

    String title;
    String author;
    double price;

    //Default book constructor to create book object.
    Book(){
        this.title = "NA";
        this.author = "NA";
        this.price = 0;
    }

    //Parmeterized Book constructor to create book object
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void bookDetails(){
        System.out.println("Book title: "+title);
        System.out.println("Book author: "+author);
        System.out.printf("Book price: %.2f%n",price);
        System.out.println("--------------------------------------------------------");
    }
    public static void main(String[] args) {
        Book book1 = new Book();        //Creating book object using default constructor
        Book book2 = new Book("Crime And Punishment","Fyodor Dostoevsky",400);      //Creating book object using parameterized constructor
        
        System.out.println("Default constructor book object attributes: ");
        book1.bookDetails();
        System.out.println("Parameterized constructor book object attributes: ");
        book2.bookDetails();

    }
}
