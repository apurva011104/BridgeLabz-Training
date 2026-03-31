interface Reservable{
    public void reserveItem( User borrower );
    public boolean checkAvailability();
}

abstract class LibraryItem implements Reservable{

    private final String itemId;
    private String title;
    private String author;
    private boolean isAvailable;
    private User borrower;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.borrower = null;
    }

    public String getItemID(){
        return itemId;
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

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public User getBorrower() {
        return borrower;
    }

    public void updateBorrower(User borrower) {
        this.borrower = borrower;
    }

    // Abstract method to get loan duration
    protected abstract int getLoanDuration();

    // Concrete method to display item details
    public void displayItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " + (isAvailable ? "Available" : "Not Available"));
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }

    @Override
    public void reserveItem(User borrower) {
        if (!isAvailable) {
            System.out.println("Item is already reserved.");
            return;
        }
        updateBorrower(borrower);
        this.isAvailable = false;
        System.out.println("Item reserved successfully by " +borrower.getName());
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }

    protected void returnItem() {
        updateBorrower(null);
        isAvailable = true;
        System.out.println("Item returned successfully.");
    }
    
}

class Book extends LibraryItem {

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    protected int getLoanDuration() {
        return 10; 
    }

    @Override
    public void displayItemDetails(){
        System.out.println("Item Type: Book");
        super.displayItemDetails();
    }
}

class Magazine extends LibraryItem {

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    protected int getLoanDuration() {
        return 7;
    }

    @Override
    public void displayItemDetails(){
        System.out.println("Item Type: Magazine");
        super.displayItemDetails();
    }
}

class DVD extends LibraryItem {

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    protected int getLoanDuration() {
        return 4;
    }

    @Override
    public void displayItemDetails(){
        System.out.println("Item Type: DVD");
        super.displayItemDetails();
    }
}

class User{

    private final String userId;
    private String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserID() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}



public class LibraryManagementSystem {
    public static void main(String[] args) {

        LibraryItem book1 = new Book("LTB147826", "Romeo & Juliet", "William Shakespeare");
        LibraryItem magazine1 = new Magazine("LTM205486", "Tech Today", "Editorial Team");
        LibraryItem dvd1 = new DVD("LTD143340", "Inception", "Christopher Nolan");

        LibraryItem[] items = {book1,magazine1,dvd1};

        User borrower1 = new User("UUID14895", "Ava");
        User borrower2 = new User("UUID17532", "Violet");

        for(LibraryItem item: items){

            item.displayItemDetails();
            item.reserveItem(borrower1);
            System.out.println("Is item available?:"+item.checkAvailability());
            item.reserveItem(borrower2);
            item.returnItem();
            item.checkAvailability();
            item.reserveItem(borrower2);
            item.returnItem();
            System.out.println();
            

        }

    }
}
