import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class FindNthElementFromEnd {

    public static int takeIntegerInput(Scanner scanner, int minimumValue, int maximumValue){
        while (true){
            try {
                int n = scanner.nextInt();
                if(n>=minimumValue && n<=maximumValue){
                    scanner.nextLine();
                    return n;
                }
                System.out.print("Invalid input. Enter again: ");
            } 
            catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("Invalid input. Enter again: ");
            }
        }
    }

    public static char takeCharacterInput(Scanner scanner){
        while (true){
            try {
                String str = scanner.nextLine().trim();
                if(str.length()==1){
                    return str.charAt(0);
                }
                System.out.print("Invalid input. Enter again: ");
            } 
            catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("Invalid input. Enter again: ");
            }
        }
    }

    public static <T> T findNthElement(List<T> list, int n){
        Stack<T> stack = new Stack<>();
        for(T element: list){
            stack.push(element);
        }
        while(n!=1){
            stack.pop();
            n--;
        }
        return stack.pop();
    } 
    
    public static void main(String[] args) {
        final Scanner SCANNER = new Scanner(System.in);
        List<Character> list = new LinkedList<>();
        System.out.print("Enter number of elements to be inserted in the list: ");
        int len = takeIntegerInput(SCANNER, 1, Integer.MAX_VALUE);
        for(int i=0 ; i<len; i++){
            System.out.print("Enter character element: ");
            list.add(takeCharacterInput(SCANNER));
        }
        System.out.printf("Enter value of n in the range [1,%d]: ",len);
        int n = takeIntegerInput(SCANNER, 1, len);
        char ch = findNthElement(list, n);
        System.out.println("List: "+list);
        System.out.printf("%dth element from the end in the list: %c",n,ch);
    }
}
