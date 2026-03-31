
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamsExample {
    
    public static void main(String[] args) {
        
        try(
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
        ) {
            Thread writerThread = new Thread(()->{
                try {
                    System.out.println("Writing data into the pipe.");
                    String data = "Multiplication table of 5.\n";
                    pipedOutputStream.write(data.getBytes());
                    for(int i=1; i<=10;i++){
                        String line = "5 * "+i+" = "+(5*i)+"\n";
                        pipedOutputStream.write(line.getBytes());
                    }
                    pipedOutputStream.close();
                    System.out.println("Data written into the pipe successfully.");
                } 
                catch (IOException e) {
                    System.out.println("Error occurred while writing into the pipe.");
                }
            });

            Thread readThread = new Thread(()->{
                try {
                    int data;
                    System.out.println("Reading from the pipe.");
                    while((data = pipedInputStream.read()) != -1){
                        System.out.print((char)data);
                    }
                    System.out.println("\nData reading from the file completed successfully.");
                } 
                catch (IOException e) {
                    System.out.println("Error occurred while reading from the pipe.");
                }
            });

            writerThread.start();
            readThread.start();

            writerThread.join();
            readThread.join();
        } 
        catch (IOException | InterruptedException e) {
            System.out.println(e);
        }
    }
}
