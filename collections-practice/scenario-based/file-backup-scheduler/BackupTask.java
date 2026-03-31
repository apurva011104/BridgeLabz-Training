public class BackupTask implements Comparable<BackupTask>{
    
    private final String taskID;
    private final String folderPath;
    private int priority;

    public BackupTask(String taskID, String folderPath, int priority) throws InvalidBackupPathException{
        this.taskID = taskID;
        this.folderPath = folderPath;
        this.priority = priority;
    }


    public String getTaskID() {
        return taskID;
    }

    public String getFolderPath() {
        return folderPath;
    }

    @Override
    public int compareTo(BackupTask task) {
        return Integer.compare(task.priority, this.priority);
    }

    @Override
    public String toString() {
        return "[Backup Task ID: " + taskID +", Backup folder path: "+ folderPath + ", Priority: " + priority + "]";
    }
}
