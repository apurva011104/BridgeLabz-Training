import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateBinaryNumbers {

    public static List<String> generateBinaryNumbers(int n){
        if(n<=0){
            return new ArrayList<>();
        }

        List<String> binaryNumbers = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        while(n>0){
            String num = queue.remove();
            binaryNumbers.add(num);
            queue.offer(num+"0");
            queue.offer(num+"1");
            n--;
        }
        return binaryNumbers;
    }

    public static void main(String[] args){
        int n=5;

        List<String> binaryNumbers = generateBinaryNumbers(n);

        System.out.println("Binary Numbers List: "+binaryNumbers);
    }
}
