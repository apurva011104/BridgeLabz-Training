import java.util.Scanner;

public class ConvertStringToLowerCase {
    public static String lowerCase(String text){
        String lowercase = "";
        for(char ch: text.toCharArray()){
            if(ch>='A' && ch<='Z'){
                lowercase+=(char)(ch-'A'+'a');
            }
            else{
                lowercase+=ch;
            }
        }
        return lowercase;
    }
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scan.nextLine();
        String lowercase=lowerCase(text);
        String lowercaseUsingBuiltIn= text.toLowerCase();
        System.out.println("Lowercase using user defined method: "+lowercase);
        System.out.println("Lowercase using built in method: "+lowercaseUsingBuiltIn);
        scan.close();
    }
}
