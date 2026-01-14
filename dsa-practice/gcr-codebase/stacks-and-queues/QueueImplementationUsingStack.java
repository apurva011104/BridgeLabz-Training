import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueImplementationUsingStack {

    private final Stack<Integer> enqueue;
    private final Stack<Integer> dequeue;

    public QueueImplementationUsingStack() {
        this.enqueue = new Stack<>();
        this.dequeue = new Stack<>();
    }

    public void add(int number){
        enqueue.push(number);
    }

    public int remove() throws NoSuchElementException{
        if(enqueue.isEmpty())
            throw new NoSuchElementException("Queue is empty");
        while(enqueue.size()!=1){
            dequeue.push(enqueue.pop());
        }
        int n = enqueue.pop();
        while(!dequeue.isEmpty()){
            enqueue.push(dequeue.pop());
        }
        return n;
    }
    
    public int peek() throws NoSuchElementException{
        if(enqueue.isEmpty())
            throw new NoSuchElementException("Queue is empty");
        while(enqueue.size()!=1){
            dequeue.push(enqueue.pop());
        }
        int n = enqueue.pop();
        enqueue.push(n);
        while(!dequeue.isEmpty()){
            enqueue.push(dequeue.pop());
        }
        return n;
    }

    public int size(){
        return enqueue.size();
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void clear(){
        while(!enqueue.isEmpty()){
            enqueue.pop();
        }
    }

    @Override
    public String toString(){
        if(enqueue.isEmpty()){
            return "[]";
        }
        while(!enqueue.isEmpty()){    
            dequeue.push(enqueue.pop());
        }
        StringBuilder elements = new StringBuilder();
        elements.append("[");
        while(!dequeue.isEmpty()){
            int n=dequeue.pop();
            elements.append(n+", ");
            enqueue.push(n);
        }
        return elements.substring(0,elements.length()-2)+"]";
    }
    
    public static void main(String[] args) {
        
        QueueImplementationUsingStack  queue = new QueueImplementationUsingStack();
        queue.add(5);
        queue.add(7);
        queue.add(9);
        System.out.println(queue.toString());

        System.out.println(queue.remove());

        System.out.println(queue.peek());
        System.out.println(queue.toString());
    }
}
