package junit;

public class LongRunningTask {
    
    public static int longRunningTask() throws InterruptedException{
        int count = 2;
        Thread.sleep(5000);
        return (int)Math.pow(count, 30);
    }
}
