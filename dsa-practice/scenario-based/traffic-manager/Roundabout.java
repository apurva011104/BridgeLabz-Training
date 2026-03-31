public class Roundabout {

    private VehicleNode head;
    private VehicleNode tail;

    /*-------------------------CREATE OPERATIONS----------------------------*/
    public void addVehicle(Vehicle vehicle){

        VehicleNode vehicleNode = new VehicleNode(vehicle);
        
        if(head==null){
            head=vehicleNode;
            tail=vehicleNode;
        }
        else{
            tail.setNext(vehicleNode);
            tail = vehicleNode;
        }
        tail.setNext(head);
        System.out.println("Vehicle added to roundabout successfully");
    }

    /*----------------------------READ OPERATIONS-------------------------*/
    public void printState(){
        if(head==null){
            System.out.println("Roundabout is empty.");
            return;
        }
        System.out.print("Roundabout: ");
        VehicleNode current = head;
        do{
            displayVehicleInfo(current.getVehicle());
            System.out.print(" -> ");
            current = current.getNext();
        }
        while(current!=head);
        System.out.println("(back to start)");
    }

    public void displayVehicleInfo(Vehicle vehicle){
        System.out.printf("[Vehicle ID: %s, Vehicle Model: %s]",vehicle.getVehicleId(),vehicle.getVehicleModel());
    }

    public boolean isRoundaboutEmpty() {
        return head == null;
    }

    public boolean isVehicleInRoundabout(String vehicleID){
        if(head == null){
            return false;
        }
        VehicleNode current = head;
        do{
            if(current.getVehicle().getVehicleId().equals(vehicleID)){
                return true;
            }
            current = current.getNext();
        }
        while(current!=head);
        return false;
    }

    public int roundaboutSize(){
        if(head == null)        return 0;
        VehicleNode current = head;
        int count = 0;
        do{
            count++;
            current = current.getNext();
        }
        while(current!=head);
        return count;
    }
    
    /*----------------------------DELETE OPERATIONS---------------------------*/
    public boolean removeVehicle(String vehicleID) throws EmptyRoundAboutException{
        if(head==null){
            throw new EmptyRoundAboutException("Roundabout is empty");
        }
        VehicleNode current = head;
        VehicleNode previous = tail;
        boolean vehicleExists = false;

        do {
            if(current.getVehicle().getVehicleId().equals(vehicleID)){
                vehicleExists=true;

                if (head == tail) {
                    head = null;
                    tail = null;
                }
                else if(current==head){
                    head=head.getNext();
                    tail.setNext(head);
                }
                else if(current==tail){
                    tail = previous;
                    tail.setNext(head);
                }
                else{
                    previous.setNext(current.getNext());
                }
                current.setNext(null);
                current=null;
                break;
            }
            previous=previous.getNext();
            current=current.getNext();
        } while (current != head);

        
        return vehicleExists;
    }
}
