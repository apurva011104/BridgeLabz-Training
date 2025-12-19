import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> check=new Stack<>();       //Initialize a stack to keep track of opening parentheses
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')       //If it's an opening parentheses, push it onto the stack 
                check.push(s.charAt(i));
            else{                                                      //If it's a closing parentheses, check for matching opening parentheses
                if(check.isEmpty())
                    return false;
                else if(s.charAt(i)==')' && check.peek()!='(')
                    return false;
                else if(s.charAt(i)=='}' && check.peek()!='{')
                    return false;
                else if(s.charAt(i)==']' && check.peek()!='[')
                    return false;
                else
                    check.pop();
            }
            if(i==s.length()-1 && !check.isEmpty())
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ValidParentheses vp=new ValidParentheses();
        String s="({[]})";
        boolean result=vp.isValid(s);
        System.out.println("Is the parentheses valid? "+result);
    }
}
