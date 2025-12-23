import java.util.Scanner;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scan.next();

        char nonRepeatingCharacter=' ';

        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            boolean flag=true;
            for(int j=0;j<text.length();j++){
                if(i!=j && ch==text.charAt(j)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                nonRepeatingCharacter=ch;
                break;
            }
        }

        System.out.println("First non-repeating character: "+nonRepeatingCharacter);
    }
}
