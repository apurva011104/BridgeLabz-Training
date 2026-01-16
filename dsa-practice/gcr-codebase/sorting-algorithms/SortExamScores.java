//Problem statement: A university needs to sort students’ exam scores in ascending order. Implement Selection Sort to achieve this

import java.util.Arrays;
import java.util.Scanner;

public class SortExamScores {


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

    //Method to sort scores using selection sort
    public static void sortScores(int[] scores){

        for(int i=0 ; i<scores.length-1 ; i++){
            int minimumIndex = i;
            
            for(int j=i+1 ; j<scores.length ; j++){
                if(scores[j]<scores[minimumIndex]){
                    minimumIndex = j;
                }
            }
            swap(scores , i, minimumIndex);
        }
    }

    //Method to swap two elements in an array
    public static void swap(int[] array, int i , int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = takeIntegerInput(scan, 1);

        int []scores = new int[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter student "+(i+1)+" marks: ");
            scores[i]=takeIntegerInput(scan, 0);
        }

        System.out.println("Students' scores before sorting: "+Arrays.toString(scores));
        sortScores(scores);
        System.out.println("Students' scores after sorting: "+Arrays.toString(scores));
    }
}
