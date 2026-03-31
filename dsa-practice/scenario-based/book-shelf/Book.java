public class Book {

    private final String bookID;
    private final String title;
    private final String author;
    private boolean isAvailable;

    public Book(String bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    public void updateAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

}
