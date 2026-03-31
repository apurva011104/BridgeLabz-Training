//Problem statement:
//You are given an integer array. 
//Write a program that performs Linear Search to find the first negative number in the array. 
//If a negative number is found, return its index. If no negative number is found, return -1

import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstNegativeNumber {

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
            catch (InputMismatchException e) {
                scan.nextLine();
                System.out.print("Invalid input. Enter again: ");
                n=-1;
            }
        } 
        while (n<minimumValue);
        return n;
    }
    
    public static int firstNegativeNumber(int []nums){
        for(int  i=0; i<nums.length; i++){
            if(nums[i]<0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of integers: ");
        int len = takeIntegerInput(scan, 0);

        int[] nums = new int[len];
        for(int i=0; i<len ; i++){
            System.out.print("Enter an integer: ");
            nums[i]=takeIntegerInput(scan, Integer.MIN_VALUE);
        }
        
        int indexOfFirstNegativeNumber = firstNegativeNumber(nums);

        if(indexOfFirstNegativeNumber==-1){
            System.out.println("No negative integer found in the array");
        }
        else{
            System.out.println("Index of first negative integer: "+indexOfFirstNegativeNumber);
        }
    }
}
