import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static int[] stockSpan(int []stocks){

        int[] span  = new int[stocks.length];
        Stack<Integer> index = new Stack<>();           //Initializing stack which will store indexes
        for(int i=0 ; i<stocks.length ; i++){
            int count=1;
            while(!index.isEmpty() && stocks[index.peek()]<=stocks[i]){         //Checking if index array is empty or stock price at the index stored on top of the index stack is smaller than or equal to current stock price
                count+=span[index.pop()];           //Adding the span value store at the index stored on top of the index stack and removing that index from stack
                //System.out.println(stocks[i]+" "+helper+" "+span[i]);
            }
            //System.out.println(Arrays.toString(span));
            span[i]=count;
            index.push(i);              //Pushing the current index in stack
        }
        return span;
    }

    public static void main(String[] args) {
        int []array = {100,80,60,75,60,75,85};
        int []span = stockSpan(array);
        System.out.println(Arrays.toString(span));
    }
}
