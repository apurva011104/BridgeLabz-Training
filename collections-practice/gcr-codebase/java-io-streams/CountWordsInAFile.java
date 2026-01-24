import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountWordsInAFile {
    
    public static void main(String[] args) {
        HashMap<String, Integer> wordFrequency = new HashMap<>();
        String fileName = "FileToRead.txt";

        try (
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){
            int data;
            StringBuilder word = new StringBuilder();
            System.out.println("File reading started.");
            while((data = bufferedReader.read())!=-1){
                char ch = (char)data;
                if(Character.isAlphabetic(ch) || Character.isDigit(ch)){
                    word.append(ch);
                }
                else{
                    if(word.length()!=0){
                        String w = word.toString().toLowerCase();
                        wordFrequency.put(w, wordFrequency.getOrDefault(w, 0)+1);
                    }
                    word=new StringBuilder();
                }
            }
            if(word.length()!=0){
                String w = word.toString().toLowerCase();
                wordFrequency.put(w, wordFrequency.getOrDefault(w, 0)+1);
            }
            System.out.println("File reading completed successfully");

            String[] words = new String[5];
            int[] frequency = new int[5];

            for(Map.Entry<String,Integer> entry: wordFrequency.entrySet()){
                int f= entry.getValue();
                String w = entry.getKey();
                int idx = 0;
                while(idx<5){
                    if(f>frequency[idx]){
                        break;
                    }
                    idx++;
                }
                for(int i=4;i>idx;i--){
                    frequency[i]=frequency[i-1];
                    words[i]=words[i-1];
                }
                if(idx<5){
                    frequency[idx]=f;
                    words[idx]=w;
                }
            }
            System.out.println("Most occuring words: ");
            for(int i=0; i<5 ; i++){
                if(frequency[i]==0){
                    break;
                }
                System.out.println((i+1)+". "+words[i]+": "+frequency[i]+" times");
            }

        } catch (IOException e) {
            System.out.println("Error occurred while reading file.");
        }
    }

}
