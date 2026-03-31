import java.lang.reflect.Field;

public class PrivateFieldAccesser {
    
    public static void accessPrivateField(Person person){
        try {
            
            Field field = person.getClass().getDeclaredField("age");
            field.setAccessible(true);

            int age =field.getInt(person);
            System.out.println("Age value before modification: "+age);

            field.set(person,25);
            System.out.println("Age value after modification: "+field.getInt(person));
    
        } 
        catch (NoSuchFieldException | IllegalAccessException e ) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        
        Person person = new Person(20);

        accessPrivateField(person);
    }
}

class Person{
    
    private int age;

    public Person(int age) {
        this.age = age;
    }
    
    
}