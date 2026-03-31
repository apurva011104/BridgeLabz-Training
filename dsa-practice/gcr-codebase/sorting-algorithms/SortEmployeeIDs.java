import java.util.Arrays;
import java.util.Scanner;

public class SortEmployeeIDs {
    
    //Method to take integer input
    public static int takeIntegerInput(Scanner scan, int minimumValue){
        int n;
        do { 
            try {
                n = scan.nextInt();
                if(n>=minimumValue){
                    return n;
                }
                System.out.print("Invalid input. Enter again: ");
            } 
            catch (NumberFormatException e) {
                scan.nextLine();
                System.out.print("Invalid input. Enter again: ");
                n=-1;
            }
        } 
        while (n<minimumValue);
        return n;
    }

    //Method to sort employee ids
    public static void sortIDs(String[] employeeIDs){
        //Sorting using insertion sort
        for(int i=1 ; i<employeeIDs.length ; i++){
            String id = employeeIDs[i];
            int j=i-1;
            while(j>=0 && id.compareTo(employeeIDs[j])<0){
                employeeIDs[j+1]=employeeIDs[j];
                j--;
            }
            employeeIDs[j+1]=id;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int numberOfEmployees = takeIntegerInput(scan, 1);
        String[] employeeIDs = new String[numberOfEmployees];
        for(int i=0; i<numberOfEmployees; i++){
            System.out.print("Enter employee "+(i+1)+" ID: ");
            employeeIDs[i] = scan.next();
        }
        System.out.println("Employee IDs before sorting: "+Arrays.toString(employeeIDs));
        sortIDs(employeeIDs);
        System.out.println("Employee IDs after sorting: "+Arrays.toString(employeeIDs));
    }
}
