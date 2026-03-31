import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> nums=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("/")){
                int n1=nums.pop();
                nums.push(nums.pop()/n1);
            }
            else if(tokens[i].equals("+")){
                int n1=nums.pop();
                nums.push(nums.pop()+n1);
            }
            else if(tokens[i].equals("-")){
                int n1=nums.pop();
                nums.push(nums.pop()-n1);
            }
            else if(tokens[i].equals("*")){
                int n1=nums.pop();
                nums.push(nums.pop()*n1);
            }
            else{
                nums.push(Integer.parseInt(tokens[i]));
            }
            //System.out.println(nums);
        }
        return nums.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int output = evalRPN(tokens);
        System.out.println("Value of the expression: "+output);
    }
}
