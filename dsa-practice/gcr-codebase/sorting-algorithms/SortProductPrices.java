import java.util.Arrays;
import java.util.Scanner;

public class SortProductPrices {

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


    public static void sortPrices(double[] productPrices){
        sort(productPrices,0,productPrices.length-1);
    }

    public static void sort(double[] array, int low, int high){
        if(low>=high){
            return;
        }
        int pivot = partition(array, low, high);

        sort(array, low, pivot-1);
        sort(array, pivot+1, high);

    }

    public static int partition(double[] array, int low, int high){
        double pivot = array[high];
        int idx = low - 1;

        for(int j=low ; j<=high ; j++){
            if(array[j]<pivot){
                idx++;
                swap(array,idx,j);
            }
        }
        swap(array,idx+1,high);
        return idx+1;
    }
    
    public static void swap( double[] array , int i, int j ){
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int numberOfProducts = takeIntegerInput(scan, 1);
        double[] productPrices = new double[numberOfProducts];
        for(int i=0; i<numberOfProducts ; i++){
            System.out.print("Enter product "+(i+1)+" price: ");
            productPrices[i] = takeDoubleInput(scan, 0);
        }
        System.out.println("Product prices before sorting: "+Arrays.toString(productPrices));
        sortPrices(productPrices);
        System.out.println("Product prices after sorting: "+Arrays.toString(productPrices));
        
    }
}
