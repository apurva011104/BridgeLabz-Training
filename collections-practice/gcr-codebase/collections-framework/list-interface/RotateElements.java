import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class RotateElements {

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

    public static <T>void rotateList(List<T> list, int rotations){
        int size = list.size();
        rotations %=size;

        Queue<T> queue=new LinkedList<>();
        for(int i=rotations; i<rotations+size;i++){
            queue.offer(list.get(i%size));
        }

        for(int i=0; i<size; i++){
            list.set(i, queue.poll());
        }

    }
    
    public static void main(String[] args) {
        final Scanner SCANNER = new Scanner(System.in);
        List<Integer> arrayList = new ArrayList<>();
        System.out.print("Enter number of elements to be inserted in the list: ");
        int n = takeIntegerInput(SCANNER, 1);
        for(int i=0 ; i<n; i++){
            System.out.print("Enter element: ");
            int x = takeIntegerInput(SCANNER, Integer.MIN_VALUE);
            arrayList.add(x);
        }
        System.out.print("Enter number of times you want to rotate: ");
        int rotations = takeIntegerInput(SCANNER, 0);

        System.out.println("ArrayList before rotation: "+arrayList);
        rotateList(arrayList, rotations);
        System.out.println("ArrayList after rotation: "+arrayList);
    }
}
