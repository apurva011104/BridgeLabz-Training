import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class ToDoAnnotationForPendingTasks {
    
    public static void main(String[] args) {
    
        try {
            
            Class<?> classname = PendingTask.class;

            Method[] methods = classname.getDeclaredMethods();

            for(Method method: methods){

                Todo todo = method.getAnnotation(Todo.class);

                if(todo!=null){
                    System.out.println(todo);
                }
            }
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }

    
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class PendingTask{

    @Todo(task="Assignment", assignedTo="Ava", priority="HIGH")
    public void doAssignment(){
        System.out.println("Doing Assignment");
    }

    @Todo(task="Networking", assignedTo="Ava", priority="LOW")
    public void createNetwork(){
        System.out.println("Creating Network");
    }

    @Todo(task="Cleaning workbench", assignedTo="Ava")
    public void cleanWorkBench(){
        System.out.println("Cleaning workbench");
    }
}
