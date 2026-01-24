import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamsFileCopy {

    static final int CHUNKS_SIZE = 4096;

    public static void readAndCopyFileByUnbufferedStream(String fileName , String outputFile ){
        try(
            FileInputStream fileInputStream = new FileInputStream(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        ){
            byte[] chunk = new byte[CHUNKS_SIZE];
            int character;
            System.out.println("Starting copying file by unbuffered streams.");
            long startTime = System.nanoTime();
            while((character = fileInputStream.read(chunk))!= -1){
               fileOutputStream.write(chunk, 0, character);
            }
            long endTime = System.nanoTime();
            System.out.println("File copied successfully by unbuffered streams.");
            long totalTimeTaken = endTime-startTime;
            System.out.println("Total time taken to copy the file by unbuffered streams: "+totalTimeTaken+" nanoseconds.");
        }
        catch(IOException e){
            System.out.println("Error occured while copying the file.");
        }
    }

    public static void readAndCopyFileByBufferedStream(String fileName , String outputFile ){
        try(
            FileInputStream fileInputStream = new FileInputStream(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ){
            byte[] chunk = new byte[CHUNKS_SIZE];
            int character;
            System.out.println("Starting copying file by buffered streams.");
            long startTime = System.nanoTime();
            while((character = bufferedInputStream.read(chunk)) != -1){
                bufferedOutputStream.write(chunk, 0, character);
            }
            long endTime = System.nanoTime();
            System.out.println("File copied successfully by buffered streams.");
            long totalTimeTaken = endTime-startTime;
            System.out.println("Total time taken to copy the file by buffered streams: "+totalTimeTaken+" nanoseconds.");
        }
        catch(IOException e){
            System.out.println("Error occured while copying the file.");
        }
    }

    
    public static void main(String[] args) {
        
        String fileName = "FileToRead.txt";
        String outputFile1 = "Output1.txt";
        String outputFile2 = "Output2.txt";
        readAndCopyFileByBufferedStream(fileName, outputFile1);
        readAndCopyFileByUnbufferedStream(fileName, outputFile2);
    }

}
