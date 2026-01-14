import java.util.Stack;

public class SortStackUsingRecursion {

    private static void insertElement(Stack<Integer> stack, int element){
        if(stack.isEmpty() || stack.peek()<=element){       //Base Case: Returning if stack is empty or the top element of stack is smaller or equal to the element to insert.
            stack.push(element);        //Adding element as it will be larger or equal to the top element if stack is not empty or the smallest if stack is empty
            return;
        }
        int n = stack.pop();
        insertElement(stack, element);      //Making recursive calls until stack is empty or the "element" is smaller than the top element of the stack
        stack.push(n);          //Pushing back elements after adding the smaller elements than these elements
    }

    public static void sortStack(Stack<Integer> stack){
        if(stack.isEmpty()){        //Base case: Returning if stack is empty
            return;
        }
        int n = stack.pop();
        //System.out.println(n);
        sortStack(stack);               //Making recursive calls until stack is empty
        insertElement(stack, n);        //Inserting elements back to stack    
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<10;i++){
            int num = (int)(Math.random()*100);
            stack.add(num);
        }

        System.out.println("Stack before sort: "+stack);
        sortStack(stack);
        System.out.println("Stack after sort: "+stack);
    }
}
