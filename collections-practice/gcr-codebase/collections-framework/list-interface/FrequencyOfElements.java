import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FrequencyOfElements {
    
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

    public static String takeStringInput(Scanner scanner){
        while (true) { 
            try {
                String str = scanner.nextLine().trim();
                if(str.length()!=0){
                    return str;
                }
                System.out.print("Invalid input. Enter again: ");
            } 
            catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.print("Invalid input. Enter again: ");
            }
        }
    }


    public static Map<String, Integer> countFrequency(List<String> list){
        Map<String, Integer> frequency = new TreeMap<>();

        for(String element: list){
            frequency.putIfAbsent(element, 0);
            frequency.replace(element, frequency.get(element)+1);
        }

        return frequency;
    }
    
    public static void main(String[] args) {
        final Scanner SCANNER = new Scanner(System.in);
        List<String> arrayList = new ArrayList<>();
        System.out.print("Enter number of elements to be inserted in the list: ");
        int n = takeIntegerInput(SCANNER, 1);
        for(int i=0; i<n ;i++){
            System.out.print("Enter element: ");
            arrayList.add(takeStringInput(SCANNER));
        }

        Map<String, Integer> frequency = countFrequency(arrayList);
        System.out.println("Frequency of elements: "+frequency);
    }
}
