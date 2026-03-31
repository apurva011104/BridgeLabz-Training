import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Task{

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu").withResolverStyle(ResolverStyle.STRICT);
    private final String taskId;
    private String taskName;
    private int priority;
    private LocalDate dueDate;

    public Task(String taskId, String taskName, int priority, String dueDate){
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = LocalDate.parse(dueDate, formatter); 
        
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getPriority() {
        return priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void displayTaskInfo(){
        System.out.print("Task ID: "+taskId);
        System.out.print(", Task Name: "+taskName);
        System.out.print(", Priority: "+priority);
        System.out.println(", Due date: "+dueDate);
    }

}


class TaskNode{

    private Task task;
    private TaskNode next;

    public TaskNode(Task task) {
        this.task = task;
    }

    public TaskNode(Task task, TaskNode next) {
        this.task = task;
        this.next = next;
    } 

    public Task getTask() {
        return task;
    }

    public TaskNode getNext() {
        return next;
    }

    public void setNext(TaskNode next) {
        this.next = next;
    }

    
}

public class TaskScheduler {
    
    Set<String> allTaskIDs;
    TaskNode taskHead;
    TaskNode taskTail;
    TaskNode pointer;

    public TaskScheduler() {
        this.allTaskIDs = new HashSet<>();
    }

    public int size(){
        return allTaskIDs.size();
    }

    /*---------------------------- CREATE OPERATIONS ----------------------------------*/
    
    public void addTaskAtTheBeginning(String taskId, String taskName, int priority, String dueDate){
        if(allTaskIDs.contains(taskId)){
            System.out.println("Task ID already exists");
            return;
        }
        try {
            Task newTask = new Task(taskId, taskName, priority, dueDate);
            TaskNode newTaskNode = new TaskNode(newTask);
            
            if(taskHead == null){
                taskHead=newTaskNode;
                taskTail=newTaskNode;
                pointer=taskHead;
                newTaskNode.setNext(newTaskNode);
            }
            else{
                newTaskNode.setNext(taskHead);
                taskHead=newTaskNode;
                taskTail.setNext(taskHead);
            }
            allTaskIDs.add(taskId);
            System.out.println("Task added successfully at the beginning");
        } 
        catch (DateTimeParseException e) {
            System.out.println("Invalid date");
        } 
    }
    
    public void addTaskAtTheEnd(String taskId, String taskName, int priority, String dueDate){
        if(allTaskIDs.contains(taskId)){
            System.out.println("Task ID already exists");
            return;
        }
        try {
            Task newTask = new Task(taskId, taskName, priority, dueDate);
            TaskNode newTaskNode = new TaskNode(newTask);
            
            if(taskHead == null){
                taskHead=newTaskNode;
                taskTail=newTaskNode;
                pointer=taskHead;
                newTaskNode.setNext(newTaskNode);
            }
            else{
                taskTail.setNext(newTaskNode);
                taskTail=newTaskNode;
                taskTail.setNext(taskHead);
            }
            allTaskIDs.add(taskId);
            System.out.println("Task added successfully at the end");
        } 
        catch (DateTimeParseException e) {
            System.out.println("Invalid date");
        } 
    }

    public void addTask(String taskId, String taskName, int priority, String dueDate, int positionToAddAt){
        if(allTaskIDs.contains(taskId)){
            System.out.println("Task ID already exists");
            return;
        }
        int currentSize = size();

        if(positionToAddAt<0 || positionToAddAt>currentSize){
            System.out.println("Invalid position");
            return;
        }
        if(positionToAddAt == 0){
            addTaskAtTheBeginning(taskId, taskName, priority, dueDate);
        }
        else if(positionToAddAt == currentSize){
            addTaskAtTheEnd(taskId, taskName, priority, dueDate);
        }
        else{
            try {

                Task newTask = new Task(taskId, taskName, priority, dueDate);
                TaskNode newTaskNode = new TaskNode(newTask);

                int currentPosition = 0;
                TaskNode current = taskHead;
                while(currentPosition<positionToAddAt-1){
                    current=current.getNext();
                    currentPosition++;
                }
                newTaskNode.setNext(current.getNext());
                current.setNext(newTaskNode);
                allTaskIDs.add(taskId);
                System.out.println("Task added successfully");

            }
            catch (DateTimeParseException e) {
                System.out.println("Invalid date");
            } 
        }
         
    }

    /*---------------------------- READ OPERATIONS ----------------------------------*/
    public void viewCurrentTask(){
        if(size()==0){
            System.out.println("No tasks scheduled.");
            return;
        }
        if(pointer == null){
            pointer=taskHead;
        }
        System.out.println("Current task: ");
        pointer.getTask().displayTaskInfo();
        System.out.println();
        pointer=pointer.getNext();
    }


    public void displayAllTasks(){
        if(taskHead == null){
            System.out.println("No tasks to display");
            return;
        }
        System.out.println("All tasks: ");
        int size = size();
        TaskNode current = taskHead;
        for(int i=0;i<size;i++){
            current.getTask().displayTaskInfo();
            current=current.getNext();
        }
    }

    public ArrayList<TaskNode> searchTaskByPriority(int priority){
        ArrayList<TaskNode> foundTasks=new ArrayList<>();
        if(taskHead == null){
            return foundTasks;
        }
        TaskNode current = taskHead;
        
        do{
            if(current.getTask().getPriority() == priority){
                foundTasks.add(current);
            }
            current=current.getNext();
        }while(current!=taskHead);

        return foundTasks;
    }

    public void searchTask(int priority){
        ArrayList<TaskNode> foundTasks= searchTaskByPriority(priority);

        if(foundTasks.size()==0){
            System.out.println("No task found");
        }
        else{
            System.out.println("Found tasks: ");
            for(TaskNode task: foundTasks ){
                task.getTask().displayTaskInfo();
            }
        }
            
    }
    /*---------------------------- UPDATE OPERATIONS ----------------------------------*/
    /*---------------------------- DELETE OPERATIONS ----------------------------------*/
    public void removeTask(String taskId){

        if(!allTaskIDs.contains(taskId)){
            System.out.println("No such task exists");
            return;
        }

        if(taskId.equals(taskHead.getTask().getTaskId())){
            TaskNode temp=taskHead;
            if(taskHead.getNext().equals(taskHead)){
                taskTail=null;
                pointer=null;
            }
            else{
                if(pointer==taskHead){
                    pointer=pointer.getNext();
                }
                taskTail.setNext(taskHead.getNext());
                taskHead=taskHead.getNext();
            }
            temp.setNext(null);
            temp = null;
            allTaskIDs.remove(taskId);
            System.out.println("Task removed successfully");

        }
        else{
            TaskNode current = taskHead;
            while(current.getNext()!=taskHead && !taskId.equals(current.getNext().getTask().getTaskId())){
                current=current.getNext();
            }
            if(pointer==current.getNext()){
                pointer=pointer.getNext();
            }
            TaskNode temp = current.getNext();
            if(current.getNext().equals(taskTail)){
                current.setNext(taskHead);
                taskTail=current;
            }
            else{
                current.setNext(temp.getNext());
            }
            allTaskIDs.remove(taskId);
            temp.setNext(null);
            temp=null;
        }
    }

    public static void main(String[] args) {
        TaskScheduler schedule = new TaskScheduler();

        schedule.addTask("TS24589898", "Submit assignment", 1, "12-12-2025", 0);
        schedule.addTaskAtTheBeginning("TS5658769", "Make design pattern", 3, "12-01-2026");
        schedule.addTaskAtTheEnd("TS5612769", "Study for exams", 1, "20-01-2026");

        schedule.displayAllTasks();

        schedule.searchTask(1);

        schedule.viewCurrentTask();
        schedule.viewCurrentTask();

        schedule.removeTask("TS5612769");

        schedule.displayAllTasks();
    }
}
