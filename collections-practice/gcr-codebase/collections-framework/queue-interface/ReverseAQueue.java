import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseAQueue {
    
    public static <T> void reverseQueue(Queue<T> queue){
        if(queue.isEmpty()){
            return;
        }
        T current = queue.remove();
        reverseQueue(queue);
        queue.add(current);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Queue before reversing: "+queue);
        reverseQueue(queue);
        System.out.println("Queue after reversing: "+queue);
    }
}
