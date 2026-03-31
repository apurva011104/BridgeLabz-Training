import java.util.Scanner;

public class LengthOfString {

    public static int stringLength(String str){
        int index=0;
        try {
            while(true){
                char ch=str.charAt(index);
                index++;
            }
        }
        catch (Exception e) {
            
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scan.nextLine();

        int lengthUsingUserDefined = stringLength(text);
        int lengthUsingBuiltIn = text.length();

        System.out.println("Length using user defined method: "+lengthUsingUserDefined);
        System.out.println("Longth using built in method: "+lengthUsingBuiltIn);

    }
}
