import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConvertUppercaseToLowercase {

    public static void conversionUsingFileReaderAndWriter(String fileName, String outputFileName){

        try(
            FileReader fileReader = new FileReader(fileName);
            FileWriter fileWriter = new FileWriter(outputFileName);
        ){
            int character;
            long startTimeForFile = System.nanoTime();
            while((character = fileReader.read())!=-1){
                if(character>='A' && character<='Z'){
                    fileWriter.write(character+('a'-'A'));
                }
                else{
                    fileWriter.write(character);
                }
            }
            long endTimeForFile = System.nanoTime();
            long timeTakenByFile = endTimeForFile - startTimeForFile;
            System.out.println("File copied successfully using FileReader and FileWriter");
            System.out.println("Time taken: "+timeTakenByFile+" nanoseconds");
        } 
        catch (IOException e) {
            System.out.println(e);
        }
        
    }

    public static void conversionUsingBufferedReaderAndWriter(String fileName, String outputFileName){

        try(
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(outputFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ){
            int character;
            long startTimeForBuffered = System.nanoTime();
            while((character = bufferedReader.read())!=-1){
                if(character>='A' && character<='Z'){
                    bufferedWriter.write(character+('a'-'A'));
                }
                else{
                    bufferedWriter.write(character);
                }
            }
            long endTimeForBuffered = System.nanoTime();
            long timeTakenByBuffered = endTimeForBuffered - startTimeForBuffered;
            System.out.println("File copied successfully using BufferedReader and BufferedWriter");
            System.out.println("Time taken: "+timeTakenByBuffered+" nanoseconds");
        } 
        catch (IOException e) {
            System.out.println(e);
        }
        
    }


    public static void main(String[] args) {

        String fileName= "FileToRead.txt";
        String outputFileName1 = "OutputFile1.txt";
        String outputFileName2 = "OutputFile2.txt";        

        conversionUsingFileReaderAndWriter(fileName, outputFileName1);
        conversionUsingBufferedReaderAndWriter(fileName, outputFileName2);
        
    }
}
