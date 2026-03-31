import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CustomObjectMapper {
    
    public static <T> T toObject(Class<T> clazz , Map<String, Object> properties){
        try {
            T classInstance = clazz.getDeclaredConstructor().newInstance();
            Field[] fields = clazz.getDeclaredFields();

            for(Field field: fields){
                String fieldName = field.getName();
                if(properties.containsKey(fieldName)){
                    Object value = properties.get(fieldName);
                    field.setAccessible(true);

                    if(field.getType().isInstance(value)){
                        field.set(classInstance, value);
                    }
                }
            }
            return classInstance;
        } 
        catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        
        Map<String, Object> properties = new HashMap<>();
        properties.put("ID","PER123");
        properties.put("name","Ava");
        properties.put("age",21);

        Person person = toObject(Person.class, properties);
        System.out.println(person);

    }
}


class Person{
    String ID;
    String name;
    int age;

    public Person() {
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Age: %d", ID, name, age);
    }
}