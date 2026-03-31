import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RetrieveAnnotationAtRuntime {
    
    public static void retrieveAnnotation(String classname){
        try {
            Class<?> className = Class.forName(classname);

            if(className.isAnnotationPresent(Author.class)){
                Author author = className.getAnnotation(Author.class);
                System.out.println("Author name: "+author.name());
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        retrieveAnnotation("Book");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface Author{
    String name();
}

@Author(name = "Ava")
class Book{

    public static void display(){
        System.out.println("This is a book class");
    }
   
}

