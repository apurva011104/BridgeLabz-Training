import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class MarkImportantMethodsExample {

    @ImportantMethod
    public static void doHomework(){
        System.out.println("Doing Homework...");
    }

    @ImportantMethod(level="LOW")
    public static void playGames(){
        System.out.println("Playing Games...");
    }

    public static void main(String[] args) {
        try {
            Class<?> classname = MarkImportantMethodsExample.class;

            Method method1 = classname.getDeclaredMethod("doHomework");
            Method method2 = classname.getDeclaredMethod("playGames");

            ImportantMethod annotation1 = method1.getAnnotation(ImportantMethod.class);
            ImportantMethod annotation2 = method2.getAnnotation(ImportantMethod.class);

            if(annotation1!=null){
                System.out.print("Method name: "+method1.getName()+", ");
                System.out.println(annotation1);
            }
            if(annotation2!=null){
                System.out.print("Method name: "+method2.getName()+", ");
                System.out.println(annotation2);
            }
        } 
        catch (Exception e) {
        }
    }
    
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod{
    String level() default "HIGH";
}