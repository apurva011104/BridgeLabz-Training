import java.util.ArrayList;
import java.util.Scanner;

public class FrequencyUsingNestedLoop {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scan.next();

        ArrayList<ArrayList<String>> frequency=new ArrayList<>();

        for(int i=0;i<text.length();i++){
            ArrayList<String> characterFrequency=new ArrayList<>();
            int count=0;
            for(int j=0;j<text.length();j++){
                if(text.charAt(i)==text.charAt(j))      count++;
            }
            characterFrequency.add(text.charAt(i)+"");
            characterFrequency.add(count+"");
            frequency.add(characterFrequency);
        }

        System.out.println("Character     Frequency");
        for(ArrayList<String> characterFrequency: frequency){
            System.out.println("    "+characterFrequency.get(0)+"             "+characterFrequency.get(1));
        }
    }
}
