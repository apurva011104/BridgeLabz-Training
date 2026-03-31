import java.util.ArrayList;
import java.util.List;

public class VesselUtil {
    
    private List<Vessel> vesselList;

    public VesselUtil() {
        this.vesselList = new ArrayList<>();
    }

    public void addVesselPerformance(Vessel vessel){
        if(getVesselById(vessel.getVesselId())!=null){
            System.out.println("Vessel is already present in vessel list.");
            return;
        }
        vesselList.add(vessel);
    }

    public Vessel getVesselById(String vesselId){
        for(Vessel vessel: vesselList){
            if(vessel.getVesselId().equals(vesselId)){
                return vessel;
            }
        }

        return null;
    }

    public List<Vessel> getHighPerformanceVessels(){
        double maximumSpeed = 0;

        for(Vessel vessel: vesselList){
            maximumSpeed=Math.max(maximumSpeed, vessel.getAverageSpeed());
        }

        List<Vessel> vessels = new ArrayList<>();

        for(Vessel vessel: vesselList){
            if(vessel.getAverageSpeed()==maximumSpeed){
                vessels.add(vessel);
            }
        }

        return vessels;

    }
    
}
