package junit;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {
    
    public static void writeToFile(String filename, String content){
        try(
            FileWriter fileWriter = new FileWriter(filename);
        ) {
            fileWriter.write(content);
            
        } catch (IOException e) {
            System.out.println("File not found or some error occured while writing the file");
        }
    }

    public static void readFromFile(String filename){

        try(
            FileReader fileReader = new FileReader(filename);
        ) {
            int character;
            while((character =  fileReader.read()) != -1){
                System.out.print((char)character);
            }
            
        } catch (IOException e) {
            System.out.println("File not found or some error occured while reading the file");
        }
    }
}
