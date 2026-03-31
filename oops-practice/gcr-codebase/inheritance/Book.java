import java.time.DateTimeException;
import java.time.Year;

public class Book {
    String title;
    Year publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        try {
            this.publicationYear = Year.of(publicationYear);
        } 
        catch (DateTimeException e) {
            System.out.println("Invalid year");
        }
    }

    public void displayInfo(){
        System.out.println("Book Title: "+title);
        System.out.println("Book Publication Year: "+publicationYear);
    }
    
}

class Author extends Book{

    String name;
    String bio;

    public Author(String title, String name, String bio, int publicationYear){
        super(title, publicationYear);
        this.name=name;
        this.bio=bio;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Author name: "+name);
        System.out.println("Author bio: "+bio);
    }
}

//Main class for testing 
class Main{
    public static void main(String[] args) {
        Book book1 = new Book("Crime and Punishment",1866);

        Author author1 = new Author("Alice's Adventures in Wonderland","Lewis Caroll","Born in January 27, 1832, in Daresbury, England. Excelled at Mathematics, attending Christ Church, Oxford, Also known for the novel \"Through The Looking-Glass\" and poem \"The Hunting of the Snark\". Died in January 14, 1898 in Guildford, England",1865);

        book1.displayInfo();
        System.out.println();
        author1.displayInfo();
    }
}