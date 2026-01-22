
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class StackImplementationUsingQueue<T>{

    Queue<T> queue1;
    Queue<T> queue2;

    public StackImplementationUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(T element){
        queue1.add(element);
    }

    public T pop(){
        if(queue1.isEmpty() && queue2.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        while(queue1.size()!=1){
            queue2.add(queue1.remove());
        }
        T top= queue1.remove();
        while(!queue2.isEmpty()){
            queue1.add(queue2.remove());
        }
        return top;
    }

    public T top(){
        if(queue1.isEmpty() && queue2.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        while(queue1.size()!=1){
            queue2.add(queue1.remove());
        }
        T top= queue1.remove();
        queue2.add(top);
        while(!queue2.isEmpty()){
            queue1.add(queue2.remove());
        }
        return top;
    }
    
    public boolean isEmpty(){
        return queue1.size()==0;
    }

    public int size(){
        return queue1.size();
    }

    public void display(){
        System.out.println("Stack: "+queue1);
    }

    public static void main(String[] args) {
        StackImplementationUsingQueue<Integer> stack = new StackImplementationUsingQueue<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.display();

        stack.pop();

        stack.display();
        int top = stack.top();
        System.out.println("Top element: "+top);
    }
}
