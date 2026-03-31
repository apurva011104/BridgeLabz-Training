import java.util.Scanner;

public class IllegalArgumentExceptionExample {

    public static String substring(String text, int start, int end){
        if(start<0 || start>=text.length() || end<start || end>text.length()){
            throw new IllegalArgumentException("Illegal Argument Exception");
        }
        return text.substring(start,end);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text=scan.nextLine();
        int start=0;
        int end=-5;
        try {
            String substring = substring(text,start,end);
            System.out.println("Substring from index "+start+" to index "+end+" is "+substring);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
