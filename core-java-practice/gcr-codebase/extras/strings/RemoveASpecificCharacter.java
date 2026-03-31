import java.util.Scanner;

public class RemoveASpecificCharacter {

    public static String removeCharacter(String text, char ch){
        StringBuilder newText = new StringBuilder();
        for(char t: text.toCharArray()){
            if(t==ch){
                continue;
            }
            newText.append(t);
        }
        return newText.toString();
    }
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text=  scan.nextLine();
        System.out.print("Enter a character you want to remove: ");
        char ch = scan.next().charAt(0);
        System.out.println("String after removing the character: "+removeCharacter(text, ch));
        scan.close();
        
    }
    
}
