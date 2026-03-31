import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class LoggingMethodExecutionTime {
    
    public static void main(String[] args) {
        Task task = new Task();
        try {

            Class<?> taskClass = Task.class;

            Method[] methods = taskClass.getDeclaredMethods();

            for(Method method: methods){
                LogExecutionTime logExecutionTime = method.getAnnotation(LogExecutionTime.class);
               
                if(logExecutionTime!=null){
                    method.setAccessible(true);

                    long startTime = System.nanoTime();
                    method.invoke(task);
                    long endTime = System.nanoTime();

                    System.out.println("Time taken by '"+method.getName()+"' to complete execution: "+(endTime-startTime)+" nanoseconds");
                }
            }
            
        } 
        catch (Exception e) {
            System.out.println("e");
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime{}

class Task{

    @LogExecutionTime
    public void runLoopThouandTimes(){
        for(int i=0; i<1000;i++);
    }

    @LogExecutionTime
    public void runLoopTenThousandTimes(){
        for(int i=0; i<10000;i++);
    }

    public void runLoopHundredTimes(){
        for(int i=0; i<100;i++);
    }

}