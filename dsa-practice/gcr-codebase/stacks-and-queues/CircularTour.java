
import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {

    public static int findStartingPoint(int[] petrol, int[] distanceToNextStation){

        Queue<Integer> indexQueue = new LinkedList<>();

        int totalPetrol = 0;
        int totalDistance = 0;

        for(int i=0;i< petrol.length; i++){
            totalPetrol+= petrol[i];
            totalDistance += distanceToNextStation[i];
        }

        if(totalPetrol<totalDistance){
            return -1;
        }

        int currentPetrol = 0;
        
        for(int i=0 ; i<petrol.length ; i++){
            indexQueue.add(i);
            if(currentPetrol + petrol[i]< distanceToNextStation[i]){ 
                while(!indexQueue.isEmpty()){
                    indexQueue.remove();
                }
                currentPetrol=0;
            }
            else{
                currentPetrol += petrol[i]-distanceToNextStation[i];
            }
        }
        return indexQueue.peek();
    }

    public static void main(String[] args) {
        int[] petrol = {1,2,3,4,5};
        int[] distanceToNextStation = {3,4,5,1,2};
        int startPoint = findStartingPoint(petrol, distanceToNextStation);
        System.out.println("Starting index: "+startPoint);
    }
}
