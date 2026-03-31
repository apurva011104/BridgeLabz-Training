
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DynamicMethodInvocator {
    
    public static void invokeDynamicMethod(String operationName, int a, int b){

        try {
            Class<?> mathOperationClass = Class.forName("MathOperations");
            Method method = mathOperationClass.getDeclaredMethod(operationName, int.class, int.class);

            int result = (Integer) method.invoke(null,a,b);
            System.out.println("Result of "+operationName+" operation: "+result);

        } 
        catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        
        invokeDynamicMethod("add", 5, 7);
        invokeDynamicMethod("subtract", 5, 7);
        invokeDynamicMethod("multiply", 5, 7);
        
    }
}

class MathOperations{

    public static int add(int a, int b){
        return a+b;
    }

    public static int subtract(int a, int b){
        return a-b;
    }

    public static int multiply(int a, int b){
        return a*b;
    }
}
