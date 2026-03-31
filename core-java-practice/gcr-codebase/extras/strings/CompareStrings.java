import java.util.Scanner;

public class CompareStrings {

    public static int lexicographicalComparison(String text1, String text2){
        int index1=0, index2=0;
        while(index1<text1.length() && index2<text2.length()){
            if(text1.charAt(index1)>text2.charAt(index2)){
                return 1;
            }
            if(text1.charAt(index1)<text2.charAt(index2)){
                return -1;
            }
            index1++;
            index2++;
        }
        if(index2<text2.length()){
            return -1;
        }
        if(index1<text1.length()){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter text 1: ");
        String text1=  scan.next();
        System.out.print("Enter text 2: ");
        String text2=  scan.next();
        int compare = lexicographicalComparison(text1, text2);
        if(compare==1){
            System.out.println(text1+" is lexicographically greater than "+text2);
        }
        else if(compare == -1){
            System.out.println(text1+" is lexicographically smaller than "+text2);
        }
        else{
            System.out.println(text1+" is lexicographically equal to "+text2);
        }
    }
}
