import java.util.ArrayList;
import java.util.Scanner;

public class SplitString2 {
    
    public static int stringLength(String str){
        int index=0;
        try {
            while(true){
                char ch=str.charAt(index);
                index++;
            }
        }
        catch (Exception e) {}
        return index;
    }

    public static String[][] splitString(String text){
        ArrayList<ArrayList<String>> listOfWords = new ArrayList<>();
        int length=stringLength(text);

        while(length>0 && text.charAt(length-1)==' '){
            length--;
        }
        
        text=text.substring(0,length);
        int index=0;

        while(index < length){
            ArrayList<String> word = new ArrayList<>();
            int left=index;
            while(index<length && text.charAt(index)!=' '){
                index++;
            }
            String w=text.substring(left,index);
            word.add(w);
            word.add(""+stringLength(w));
            listOfWords.add(word);
            index++;
        }

        String [][]words=new String[listOfWords.size()][2];
        for(int i=0; i<listOfWords.size() ;i++){
            words[i][0]=listOfWords.get(i).get(0);
            words[i][1]=listOfWords.get(i).get(1);
        }

        return words;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scan.nextLine();
        
        String [][] splitString= splitString(text);

        System.out.println("Words after splitting along with their length: ");
        for(String []words: splitString){
            System.out.println("Word: "+words[0]+", Length: "+words[1]);
        }
    }
}
