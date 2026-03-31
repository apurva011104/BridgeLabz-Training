import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class CustomAnnotationExample {
    
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Class<?> taskManagerClass = TaskManager.class;

        try {
            Method method = taskManagerClass.getDeclaredMethod("assignTask");
            TaskInfo taskInfo  = method.getAnnotation(TaskInfo.class);
            if(taskInfo!=null){
                System.out.println("TaskInfo priority: "+taskInfo.priority());
                System.out.println("TaskInfo assigned to: "+taskInfo.assignedTo());
            }

        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}


@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo{
    int priority();
    String assignedTo();
}

class TaskManager{

    @TaskInfo(priority=2, assignedTo="Ava")
    public void assignTask(){
        System.out.println("Task assigned successfully");
    }
}