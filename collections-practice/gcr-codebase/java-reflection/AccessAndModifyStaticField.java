
import java.lang.reflect.Field;

public class AccessAndModifyStaticField {
    
    public static void accessAndModifyStaticField(String classname, String fieldName, String newValue){
        try {
            Class<?> className = Class.forName(classname);
            Field field = className.getDeclaredField(fieldName);
            field.setAccessible(true);
            String oldValue = (String) field.get(null);
            System.out.println("Old value of static field '"+fieldName+"': "+oldValue);
            field.set(null, newValue);
            System.out.println("Value modified successfully");
        } 
        catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        accessAndModifyStaticField("Configuration", "API_KEY", "NEW_API_KEY");
    }
}

class Configuration{
    private static String API_KEY = "API_KEY";
}
