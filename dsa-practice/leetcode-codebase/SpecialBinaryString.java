import java.util.Collections;
import java.util.PriorityQueue;

public class SpecialBinaryString{
    public static String makeLargestSpecial(String s) {
        if(s.length()==0){
            return "";
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int oneCount=0;
        int l=0;
        for(int i=0; i<s.length() ; i++){
            if(s.charAt(i)=='1'){
                oneCount++;
            }
            else{
                oneCount--;
            }
            if(oneCount==0){
                String str = makeLargestSpecial(s.substring(l+1,i));
                maxHeap.offer(s.charAt(l)+str+s.charAt(i));
                l=i+1;
            }
        }

        StringBuilder answer = new StringBuilder();
        while(!maxHeap.isEmpty()){
            answer.append(maxHeap.poll());
        }
        return answer.toString();
    }

    public static void main(String[] args){
        String s = "11011000";
        String answer = makeLargestSpecial(s);
        System.out.println(answer);
    }
}