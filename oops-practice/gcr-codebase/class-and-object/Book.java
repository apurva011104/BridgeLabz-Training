public class Book {

    String title;
    String author;
    double price;

    //Book constructor to create book object
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    //Method to display book details
    public void displayDetails(){
        System.out.println("Title of the book: "+title);
        System.out.println("Author of the book: "+author);
        System.out.printf("Price of the book: %.2f%n",price);
    }

    public static void main(String[] args) {
        Book book1 = new Book("2State","Chetan Bhagat",500);
        Book book2 = new Book("Wings Of Fire","Abdul Kalam APJ",500);
        book1.displayDetails();
        book2.displayDetails();
    }
    
    
}
