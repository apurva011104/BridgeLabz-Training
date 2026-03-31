import java.util.Scanner;

public class ToggleCase {

    public static String toggleCase(String text){
        StringBuilder toggledString = new StringBuilder();
        for(char ch: text.toCharArray()){
            if(ch>='a' && ch<='z'){
                toggledString.append((char)(ch-'a'+'A'));
            }
            else if(ch>='A' && ch<='Z'){
                toggledString.append((char)(ch-'A'+'a'));
            }
            else{
                toggledString.append(ch);
            }
        }
        return toggledString.toString();
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text=  scan.nextLine();
        System.out.println("String after toggling case: "+toggleCase(text));
    }
}
