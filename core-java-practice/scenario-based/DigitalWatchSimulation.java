public class DigitalWatchSimulation {

    public static void digitalWatch(){
        for(int hours=0 ; hours<24 ; hours++){
            if(hours==13){
                break;
            }
            for(int minutes=0; minutes<60 ; minutes++){
                System.out.println((hours<10?"0":"")+hours+":"+(minutes<10?"0":"")+minutes);
            }
        }
    }

    public static void main(String[] args) {
        digitalWatch();
    }
}
