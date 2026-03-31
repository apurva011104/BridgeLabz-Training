//Problem statement: A school collects students’ ages (ranging from 10 to 18) and wants them sorted. Implement Counting Sort for this task.


import java.util.Arrays;
import java.util.Scanner;

public class SortStudentAges {

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

    //Method to sort ages using counting sort
    public static void sortAges(int[] age) {
        int maximumAge = age[0];        //Finding maximum age to determine the length of frequency array of ages
        for(int a: age){
            maximumAge = Math.max(maximumAge, a);
        }

        int[] ageFrequency = new int[maximumAge + 1];       //Array to store frequency of students' age
        //Counting frequency of each age
        for(int a: age){
            ageFrequency[a]++;
        }

        //Sorting ages based on frequency
        int index = 0;
        for(int i=0 ;  i<= maximumAge ; i++){
            int frequency = ageFrequency[i];
            if(frequency==0){
                continue;
            }
            for(int f=0 ; f<frequency ; f++){
                age[index] = i;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = takeIntegerInput(scan, 1);

        int []age = new int[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter student "+(i+1)+" age: ");
            age[i]=takeIntegerInput(scan, 0);
        }

        System.out.println("Students' age before sorting: "+Arrays.toString(age));
        sortAges(age);
        System.out.println("Students' age after sorting: "+Arrays.toString(age));
    }

}
