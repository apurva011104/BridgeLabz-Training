public class VehicleQueue {
    
    private final Vehicle[] vehicleQueue;
    private int front;
    private int rear;
    private int size;

    public VehicleQueue(int queueCapacity) {
        this.vehicleQueue = new Vehicle[queueCapacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    /*----------------------CREATE OPERATIONS--------------------------------*/
    public void enqueue(Vehicle vehicle) throws QueueOverflowException{
        if(size == vehicleQueue.length){
            System.out.println("Unable to add to queue");
            throw new QueueOverflowException("Waiting queue is full.");
        }
        rear = (rear+1)%vehicleQueue.length;
        vehicleQueue[rear] = vehicle;
        size++;
    }
    
    /*---------------------------READ OPERATIONS--------------------------------*/
    public boolean isQueueEmpty(){
        return size==0;
    }

    public boolean isVehicleInQueue(String vehicleID){

        int index = front;
        for(int i = 0; i < size; i++){
            if(vehicleQueue[index].getVehicleId().equals(vehicleID)){
                return true;
            }
            index = (index + 1) % vehicleQueue.length;
        }
        return false;
    }


    /*---------------------------DELETE OPERATIONS------------------------------*/
    public Vehicle dequeue() throws QueueUnderflowException{
        if(size == 0){
            System.out.println("Unable to remove from the queue.");
            throw new QueueUnderflowException("No vehicles found in the waiting queue");
        }
        Vehicle vehicle = vehicleQueue[front];
        front = (front + 1) % vehicleQueue.length;
        size--;
        return vehicle;
    }
}
