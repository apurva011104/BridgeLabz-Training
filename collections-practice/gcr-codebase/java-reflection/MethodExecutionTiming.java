import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodExecutionTiming {
    
    public static void main(String[] args) {

        try {
            Class<?> mathOperationClass = SampleClass.class;
            Method method = mathOperationClass.getDeclaredMethod("execute");
            long startTime = System.nanoTime();
            method.invoke(null);
            long endTime = System.nanoTime();

            System.out.println("Time taken for execution: "+(endTime-startTime)+"nanoseconds");

        } 
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e);
        }
    }

}

class SampleClass{
    public static void execute(){
        System.out.println("Started executing");
        int count = 0;
        for(int i=0 ; i<100 ; i++){
            count++;
        }
        System.out.println("Finished executing");
    }
}