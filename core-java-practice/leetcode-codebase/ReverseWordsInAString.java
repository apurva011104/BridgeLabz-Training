
import java.util.Stack;

public class ReverseWordsInAString {

    public String reverseWords(String s){
        int index=0;
        Stack<String> wordsStack = new Stack<>();

        while(index<s.length()){
            if(s.charAt(index)==' '){
                index++;
                continue;
            }
            int left=index;
            while(index<s.length() && s.charAt(index)!=' '){
                index++;
            }
            wordsStack.push(s.substring(left,index));
        }

        StringBuilder reverse=new StringBuilder();

        while(wordsStack.size()!=0){
            reverse.append(wordsStack.pop()+" ");
        }

        return reverse.toString().substring(0,reverse.length()-1);
    }
    public static void main(String[] args) {
        ReverseWordsInAString rev=new ReverseWordsInAString();
        String s="a good   example  ";
        String reverse=rev.reverseWords(s);
        System.out.println("Original string: "+s);
        System.out.println("After reversing words: "+reverse);
    }
    
}
