public class Book2 {
    public String ISBN;        // public variable
    protected String title;    // protected variable
    private String author;     // private variable

    // Constructor
    public Book2(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters for author
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    // Display book details
    public void displayBook() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("----------------------------------");
    }
}

class EBook extends Book2{

    private String website;

    public EBook(String ISBN, String title, String author, String website) {
        super(ISBN, title, author);
        this.website = website;
    }

    public void displayEBookDetails() {
        System.out.println("E-Book Details:");
        System.out.println("ISBN: " + ISBN);      // public variables are accessible everywhere
        System.out.println("Title: " + title);    // protected variables are accessible in subclasses
        System.out.println("File Size: " + website);
        System.out.println("Author: " + getAuthor()); // private method available via public getter method
        System.out.println("----------------------------------");
    }
}

class Main{
    public static void main(String[] args) {
        Book2 book = new Book2("978-0134685991", "Crime And Punishment","Fyodor Dostoevsky");
        book.displayBook();

        EBook ebook = new EBook("978-1492078005","Heartstopper","Alice Oseman","Kindle");
        ebook.displayEBookDetails();
    }
}