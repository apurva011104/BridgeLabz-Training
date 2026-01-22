
import java.util.NoSuchElementException;

public class CircularBufferSimulation{
    
    int[] array;
    int front=0;
    int rear=0;

    public CircularBufferSimulation(int capacity) {
        array = new int[capacity];
    }

    public void add(int element){
        if(rear<array.length){
            array[rear]=element;
            rear++;
        }
        else{
            for(int i=0 ; i<array.length-1; i++){
                array[i]=array[i+1];
            }
            array[rear-1]=element;
        }
    }
    
    public int remove(){
        if(rear<=0){
            throw new NoSuchElementException("Empty Buffer!");
        }
        int f = array[front];
        for(int i=0 ; i<array.length-1; i++){
            array[i]=array[i+1];
        }
        rear--;
        return f;
    }

    public int currentSize(){
        return rear;
    }

    public void display(){
        if(rear==0){
            System.out.println("Buffer: []");
            return;
        }
        System.out.print("Buffer: [");
        for(int i=0; i<rear-1;i++){
            System.out.print(array[i]+", ");
        }
        System.out.println(array[rear-1]+"]");
    }

    public static void main(String[] args) {
        
        CircularBufferSimulation buffer = new CircularBufferSimulation(3);

        buffer.display();
        buffer.add(1);
        buffer.add(2); 
        buffer.add(3);

        buffer.display();

        buffer.add(4);
        buffer.display();
        buffer.remove();
        buffer.display();
    }
}
