import java.util.Scanner;

public class RemoveDuplicates {

    public static String removeDuplicates(String text){
        StringBuilder newText = new StringBuilder();
        boolean[] unique = new boolean[256];
        for(char ch: text.toCharArray()){
            if(!unique[ch]){
                newText.append(ch);
                unique[ch]=true;
            }
        }
        return newText.toString();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		System.out.print("Enter text: ");
		String text = scan.next();
        System.out.println("New text after removing duplicates: "+removeDuplicates(text));
        scan.close();
    }
}
