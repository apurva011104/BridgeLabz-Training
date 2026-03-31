
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateMethodInvoker {
    
    public static void invokePrivateMethod(String classname){
        try {
            Class<?> className = Class.forName(classname);

            Method method = className.getDeclaredMethod("multiply", int.class,int.class);
            method.setAccessible(true);
            int result = (int) method.invoke(null, 2,8);
            System.out.println(result);
            
        } 
        catch (ClassNotFoundException  | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e);
        } 
    }
    public static void main(String[] args) {
        invokePrivateMethod("Calculator");
    }
}

class Calculator{
    private static int multiply(int a, int b){
        return a*b;
    }
}
