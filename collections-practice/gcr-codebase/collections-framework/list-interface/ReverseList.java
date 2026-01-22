import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReverseList{

    public static int takeIntegerInput(Scanner scanner, int minimumValue){
        while (true){
            try {
                int n = scanner.nextInt();
                if(n>=minimumValue){
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
    
    public static <T> void reverseList(List<T> list){
        int size = list.size();
        for(int i=0 ; i<size/2 ; i++){
            T temp = list.get(i);
            list.set(i, list.get(size-i-1));
            list.set(size-1-i, temp);
        }
    }

    public static void main(String[] args) {
        final Scanner SCANNER = new Scanner(System.in);
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        System.out.print("Enter number of elements to be inserted in the list: ");
        int n = takeIntegerInput(SCANNER, 1);
        for(int i=0 ; i<n; i++){
            System.out.print("Enter element: ");
            int x = takeIntegerInput(SCANNER, Integer.MIN_VALUE);
            arrayList.add(x);
            linkedList.add(x);
        }
        System.out.println("ArrayList before reversing: "+arrayList);
        reverseList(arrayList);
        System.out.println("ArrayList after reversing: "+arrayList);
        System.out.println("LinkedList before reversing: "+linkedList);
        reverseList(linkedList);
        System.out.println("LinkedList after reversing: "+linkedList);
    }
}