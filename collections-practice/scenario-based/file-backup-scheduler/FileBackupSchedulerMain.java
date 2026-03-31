public class FileBackupSchedulerMain {

    public static void addTask(BackupScheduler backupScheduler, String folderPath, int priority){
        try {
            backupScheduler.addTask(folderPath, priority);
        } catch (IllegalArgumentException | InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        BackupScheduler backupScheduler = new BackupScheduler();

        addTask(backupScheduler, "/desktop/images", 2);
        addTask(backupScheduler, "/_logs", 3);
        addTask(backupScheduler, "/logs", 4);
        addTask(backupScheduler, "/whatsapp/chat_history", 5);
        addTask(backupScheduler, "/documents/projects",3);

        backupScheduler.executeBackupTasks();
    }

}
