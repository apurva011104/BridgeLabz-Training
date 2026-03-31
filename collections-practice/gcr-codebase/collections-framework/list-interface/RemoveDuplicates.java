import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicates {
    
    public static int takeIntegerInput(Scanner scanner, int minimumValue){
        while (true){
            try {
                int n = scanner.nextInt();
                if(n>=minimumValue){
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

    public static <T> void removeDuplicates(List<T> list){
        Set<T> unique = new HashSet<>();

        int index = 0;

        while(index<list.size()){
            T element = list.get(index);
            if(unique.contains(element)){
                list.remove(index);
                continue;
            }
            unique.add(element);
            index++;
        }

    }

    public static void main(String[] args) {
        final Scanner SCANNER = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.print("Enter number of elements to be inserted in the list: ");
        int n = takeIntegerInput(SCANNER, 1);
        for(int i=0 ; i<n; i++){
            System.out.print("Enter element: ");
            list.add(takeIntegerInput(SCANNER, Integer.MIN_VALUE));
        }

        System.out.println("List before removing duplicates: "+list);
        removeDuplicates(list);
        System.out.println("List after removing duplicates: "+list);

    }
}
