//Problem statement: A company receives job applications with different expected salary demands. Implement Heap Sort to sort these salary demands in ascending order.

import java.util.Arrays;
import java.util.Scanner;

public class SortJobApplicantsBySalary {
    
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

    //Method to take double input
    public static double takeDoubleInput(Scanner scan, double minimumValue){
        double n;
        do { 
            try {
                n = scan.nextDouble();
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

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of job applicants: ");
        int numberOfApplicants = takeIntegerInput(scan, 1);

        double []salaryDemands = new double[numberOfApplicants];
        for(int i=0 ; i<numberOfApplicants ; i++){
            System.out.print("Enter applicant "+(i+1)+"'s salary demand: ");
            salaryDemands[i] = takeDoubleInput(scan, 0);
        }

        System.out.println("Salary demands before sorting: "+Arrays.toString(salaryDemands));
        sortSalaryDemands(salaryDemands);
        System.out.println("Salary demands after sorting: "+Arrays.toString(salaryDemands));
    }

    //Method to swap two elements in an array
    public static void swap(double[] array, int i , int j){
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //Method to sort salary demands using heap sort
    public static void sortSalaryDemands(double[] salaryDemands) {
        for(int i=salaryDemands.length/2 - 1; i>=0 ; i--){
            heapify(salaryDemands, salaryDemands.length,i);
        }

        for(int i= salaryDemands.length -1 ; i>0 ; i--){
            swap(salaryDemands, 0, i);
            heapify(salaryDemands,i, 0);
        }
    }

    //Method to heapify a subtree rooted with node index
    public static void heapify(double[] array, int index, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left < index && array[left]> array[largest]){
            largest = left;
        }
        if(right < index && array[right]> array[largest]){
            largest = right;
        }

        if(largest!= i){
            double temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, index, largest);
        }
    }

}
