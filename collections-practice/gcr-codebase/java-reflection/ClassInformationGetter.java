
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ClassInformationGetter {
    
    public static void displayClassInformation(String className) throws ClassNotFoundException{
        Class<?> classname = Class.forName(className);
        Field[] fields = classname.getDeclaredFields();
        Method[] methods = classname.getDeclaredMethods();
        Constructor[] constructors = classname.getDeclaredConstructors();

        System.out.println("Fields: ");
        for(Field field: fields){
            System.out.printf("Field name: %s, Type: %s, Modifier: %s%n", field.getName(), field.getType(), field.getModifiers());
        }

        System.out.println("Methods: ");
        for(Method method: methods){
            System.out.printf("Method name: %s, Return type: %s, Modifier: %s%n", method.getName(), method.getReturnType().getSimpleName(), Modifier.toString(method.getModifiers()));
        }

        System.out.println("Constructors: ");
        for(Constructor constructor: constructors){
            System.out.printf("Name: %s, Modifiers: %s, Parameters: %s%n",constructor.getName(), Modifier.toString(constructor.getModifiers()), Arrays.toString(constructor.getParameterTypes()));
        }
    }

    public static void main(String[] args) {
        
        try {
            displayClassInformation("ReflectionPracticeClass");
        } 
        catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        

    }
}

class ReflectionPracticeClass{

    String name;

    public ReflectionPracticeClass(String name) {
        this.name = name;
    }

    public static void printStatement(){
        System.out.println("This is a reflection practice class");
    }

    public void printObjectStatement(){
        System.out.println("This is an object of reflection practice class");
    }
}