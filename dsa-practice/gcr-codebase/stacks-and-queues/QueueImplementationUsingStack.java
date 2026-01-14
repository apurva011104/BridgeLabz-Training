import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueImplementationUsingStack {

    private final Stack<Integer> enqueue;
    private final Stack<Integer> dequeue;

    public QueueImplementationUsingStack() {
        this.enqueue = new Stack<>();
        this.dequeue = new Stack<>();
    }

    //Method to add integer element
    public void add(int number){
        enqueue.push(number);
    }

    //Method to remove the first element
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
    
    //Method to display the first element
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

    //Method to find size
    public int size(){
        return enqueue.size();
    }

    //Method to check if queue is empty or not
    public boolean isEmpty(){
        return size()==0;
    }

    //Method to clear the queue
    public void clear(){
        while(!enqueue.isEmpty()){
            enqueue.pop();
        }
    }

    //Method to convert the queue into string
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

        queue.clear();

        System.out.println(queue.toString());
        System.out.println(queue.isEmpty());
    }
}
