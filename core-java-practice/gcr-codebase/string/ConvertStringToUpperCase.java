import java.util.Scanner;

public class ConvertStringToUpperCase {
    public static String upperCase(String text){
        String uppercase = "";
        for(char ch: text.toCharArray()){
            if(ch>='a' && ch<='z'){
                uppercase+=(char)(ch-'a'+'A');
            }
            else{
                uppercase+=ch;
            }
        }
        return uppercase;
    }
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scan.nextLine();
        String uppercase=upperCase(text);
        String uppercaseUsingBuiltIn= text.toUpperCase();
        System.out.println("Uppercase using user defined method: "+uppercase);
        System.out.println("Uppercase using built in method: "+uppercaseUsingBuiltIn);
    }
}
