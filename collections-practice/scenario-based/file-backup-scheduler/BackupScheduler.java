import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class BackupScheduler {
    
    private final PriorityQueue<BackupTask> backupTasksQueue;
    private final Set<String> allTaskIDs;

    public BackupScheduler() {
        this.backupTasksQueue = new PriorityQueue<>();
        this.allTaskIDs = new HashSet<>();
    }

    private String generateId(){
        String id;
        do { 
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<12; i++){
                int n = (int)(Math.random()*3);
                char ch;
                switch(n){
                    case 0:
                        ch = (char)(((int)(Math.random()*26))+'A');
                        break;
                    case 1:
                        ch = (char)(((int)(Math.random()*26))+'a');
                        break;
                    default:
                        ch = (char)(((int)(Math.random()*10))+'0');
                        
                }
                sb.append(ch);
            }
            id = sb.toString();
        } 
        while (allTaskIDs.contains(id));

        return id;
    }

    private boolean isValidFolderPath(String path){
        return path != null && path.matches("(/?[a-zA-Z0-9](_?[a-zA-Z0-9])*)+");
    }

    public void addTask(String folderPath, int priority)throws InvalidBackupPathException{
        if(!isValidFolderPath(folderPath)){
            throw new InvalidBackupPathException("Folder path \""+folderPath+"\" is invalid");
        }
        if(priority < 1){
            throw new IllegalArgumentException("Invalid priority. Priority must be positive");
        }
        String id=generateId();
        BackupTask task = new BackupTask(id, folderPath, priority);
        backupTasksQueue.add(task);
        allTaskIDs.add(id);
        System.out.println("Task added successfully.");
    }

    public void executeBackupTasks(){
        if(backupTasksQueue.isEmpty()){
            System.out.println("No backup tasks to execute");
            return;
        }
        System.out.println("Executing backups started....");
        while(!backupTasksQueue.isEmpty()){
            BackupTask task = backupTasksQueue.poll();
            System.out.println("Executing Task: "+task);
            allTaskIDs.remove(task.getTaskID());
        }
        System.out.println("All backup tasks done successfully");
    }
}
