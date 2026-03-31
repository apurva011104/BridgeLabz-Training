
import java.util.Arrays;

public class LinearSearchAndBinarySearch {

    public static void fillArray(int[] array){
        for(int i=0; i<array.length ; i++){
            array[i] = (int)(Math.random()*Integer.MAX_VALUE);
        }
    }

    public static boolean linearSearch(int[] array, int target){
        for(int i=0; i<array.length; i++){
            if(array[i]==target){
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] array, int target){
        int start=0 , end=array.length;

        while(start<=end){
            int mid = start + (end - start)/2;

            if(array[mid]==target){
                return true;
            }
            if(array[mid]>target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return false;
    }


    public static long[] analyze(int[] array, int target){
        long[] timeTaken = new long[2];

        long linearSearchStartTime = System.nanoTime();
        linearSearch(array, target);
        long linearSearchEndTime = System.nanoTime();
        timeTaken[0] = linearSearchEndTime - linearSearchStartTime;

        Arrays.sort(array);

        long binarySearchStartTime = System.nanoTime();
        binarySearch(array, target);
        long binarySearchEndTime = System.nanoTime();
        timeTaken[1] = binarySearchEndTime - binarySearchStartTime;

        return timeTaken;
    }

    public static void main(String[] args) {
        int[] array1 = new int[1000];
        int[] array2 = new int[10000];
        int[] array3 = new int[1000000];
        int target = (int)(Math.random()*Integer.MAX_VALUE);

        fillArray(array1);
        fillArray(array2);
        fillArray(array3);

        System.out.println("Analysis for array whose dataset size is 1000");
        long[] analysis1 = analyze(array1, target);
        System.out.println("Time taken by linear search: "+analysis1[0]);
        System.out.println("Time taken by binary search: "+analysis1[1]);
        System.out.println();

        System.out.println("Analysis for array whose dataset size is 10000");
        long[] analysis2 = analyze(array2, target);
        System.out.println("Time taken by linear search: "+analysis2[0]);
        System.out.println("Time taken by binary search: "+analysis2[1]);
        System.out.println();

        System.out.println("Analysis for array whose dataset size is 1000000");
        long[] analysis3 = analyze(array3, target);
        System.out.println("Time taken by linear search: "+analysis3[0]);
        System.out.println("Time taken by binary search: "+analysis3[1]);
    }
}
