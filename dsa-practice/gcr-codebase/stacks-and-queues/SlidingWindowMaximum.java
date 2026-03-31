import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static int[] slidingWindowMaximum(int []array, int windowSize){
        if(array.length==0 || windowSize==0){
            return new int[0];
        }
        int []maximum = new int[array.length-windowSize+1];
        Deque<Integer> index = new ArrayDeque<>();

        for(int i=0; i<array.length ; i++){
            while(!index.isEmpty() && index.peekFirst()<=i-windowSize){
                index.pollFirst();
            }
            while(!index.isEmpty() && array[index.peekLast()]<array[i]){
                index.pollLast();
            }
            index.offerLast(i);
            if(i>=windowSize-1){
                maximum[i-windowSize+1] = array[index.peekFirst()]; 
            }
        }
        return maximum;

    }
    public static void main(String[] args) {
        int []array = {1,3,-1,-3,5,3,6,7};
        int windowSize = 3;
        int []maximum = slidingWindowMaximum(array, windowSize);
        System.out.println("Maximums in windows: "+Arrays.toString(maximum));
    }
}
