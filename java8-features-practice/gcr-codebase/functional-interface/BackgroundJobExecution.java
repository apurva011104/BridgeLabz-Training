import java.util.ArrayList;
import java.util.List;

public class BackgroundJobExecution {

    public static void main(String[] args) {
        List<Runnable> allTasks = new ArrayList<>();
        allTasks.add(()->TasksExecuter.executeTask("task-1"));
        allTasks.add(()->TasksExecuter.executeTask("task-2"));
        allTasks.add(()->TasksExecuter.executeTask("task-3"));
        allTasks.add(()->TasksExecuter.executeTask("task-4"));

        TasksExecuter.executeAllTasks(allTasks);

    }
    
}


class TasksExecuter{

    public static void executeTask(String taskName){
        System.out.println("Starting task " + taskName + "...");

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Doing task " + taskName);
            }

            Thread.sleep(1000);
            System.out.println("Completed task " + taskName);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void executeAllTasks(List<Runnable> tasks){

        List<Thread> threads = new ArrayList<>();

        for(Runnable task: tasks){
            threads.add(new Thread(task));
        }

        System.out.println("Starting all tasks...");
        for(Thread thread: threads){
            thread.start();
        }

        try {
            for(Thread thread: threads){
                thread.join();
            }
        } 
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("All tasks executed successfully.");
    }
}