import java.util.Arrays;
import java.util.Scanner;

public class SortStudentMarks {
    
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

    //Sorting marks using bubble sort
    public static void sortMarks(int[] marks){
        for(int i=0; i<marks.length; i++){
            for(int j=0;j<marks.length-i-1;j++){
                if(marks[j]>marks[j+1]){
                    int temp = marks[j];
                    marks[j]=marks[j+1];
                    marks[j+1]=temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = takeIntegerInput(scan, 1);

        int []marks = new int[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter student "+(i+1)+" marks: ");
            marks[i]=takeIntegerInput(scan, 0);
        }

        System.out.println("Marks before sorting: "+Arrays.toString(marks));
        sortMarks(marks);
        System.out.println("Marks after sorting: "+Arrays.toString(marks));

    }
}
