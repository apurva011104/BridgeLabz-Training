import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountWordOccurrenceInAFile {

    public static int countWordOccurenceInALine(String string, String word){
        int index=0;
        int count=0;
        while(index<string.length()){
            int left=index;
            while(Character.isAlphabetic(string.charAt(index)) || Character.isDigit(string.charAt(index))){
                index++;
            }
            String str= string.substring(left,index);
            if(word.equalsIgnoreCase(str)){
                count++;
            }
            index++;
        }
        return count;
    }
    
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("Sample.txt");
            String word = "computer";
            int count = 0;
            try(BufferedReader bufferedReader = new BufferedReader(fileReader) ){
                String line = bufferedReader.readLine();
                while(line!=null){
                    System.out.println(line);
                    count+=countWordOccurenceInALine(line, word);
                    line =  bufferedReader.readLine();
                }
                System.out.println("Number of times '"+word+"' appeared in file: "+count);
                fileReader.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
}
