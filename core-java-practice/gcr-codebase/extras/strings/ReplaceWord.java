import java.util.Scanner;

public class ReplaceWord {

    public static String replaceWord(String text, String toReplace, String replaceWith){
        StringBuilder newText = new StringBuilder();

        for(int i=0 ; i<=text.length()-toReplace.length() ; i++){
            if(text.substring(i,i+toReplace.length()).equals(toReplace)){
                newText.append(replaceWith);
                i+=toReplace.length()-1;
            }
            else{
                newText.append(text.charAt(i));
            }
        }
        return newText.toString();
    }
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text=  scan.nextLine();
        System.out.print("Enter a word you want to replace: ");
        String toReplace = scan.next();
        System.out.print("Enter a word you want to replace with: ");
        String replaceWith = scan.next();
        System.out.println("String after removing the character: "+replaceWord(text, toReplace, replaceWith));
        scan.close();
        
    }
}
