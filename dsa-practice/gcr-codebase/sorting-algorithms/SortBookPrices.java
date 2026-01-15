import java.util.Arrays;
import java.util.Scanner;

public class SortBookPrices {
    
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


    public static void sortPrices(double[] bookPrices){
        sort(bookPrices, 0, bookPrices.length-1);
    }

    //Implementing merge sort algorithm
    private static void sort(double[] array, int start, int end){
        if(start>=end){                 //Base Case: Start index becomes greater than or equal to end index
            return;
        }
        int mid = start + ((end-start)/2);
        //Dividing array into two parts until no more partition possible
        sort(array, start, mid);            
        sort(array, mid+1, end);
        //Merging after dividing array
        merge(array, start, end);
        
    }

    //Method to merge the divided parts in a sorted manner
    private static void merge(double[] array, int start, int end){
        int mid = start + ((end-start)/2);
        int length1 = mid - start + 1;
        int length2 = end - mid;
        double[] array1 = new double[length1];      //Will store the elements of first partition in the range
        double[] array2 = new double[length2];      //Will store the elements of second partition in the range
        for(int i=0; i<length1 ;i++){
            array1[i]=array[ i+start];
        }
        for(int i=0; i<length2 ;i++){
            array2[i]=array[i+mid+1];
        }

        int i=0, j=0;
        int k=start;
        //Merging in a sorted manner
        while(i<length1 || j<length2){
            if(i==length1){
                array[k]=array2[j];
                j++;
            }
            else if(j==length2){
                array[k]=array1[i];
                i++;
            }
            else{
                if(array1[i]<array2[j]){
                    array[k]=array1[i];
                    i++;
                }
                else{
                    array[k]=array2[j];
                    j++;
                }
            }
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int numberOfBooks = takeIntegerInput(scan, 1);
        double[] bookPrices = new double[numberOfBooks];
        for(int i=0; i<numberOfBooks ; i++){
            System.out.print("Enter book "+(i+1)+" price: ");
            bookPrices[i] = takeDoubleInput(scan, 0);
        }
        System.out.println("Book prices before sorting: "+Arrays.toString(bookPrices));
        sortPrices(bookPrices);
        System.out.println("Book prices after sorting: "+Arrays.toString(bookPrices));
    }

    
}
