public class ParcelTracker {
    
    private Parcel parcel;
    private ParcelStage headStage;

    public ParcelTracker(Parcel parcel) throws ParcelLostException{
        if(parcel.isLost()){
            throw new ParcelLostException("Lost parcel cannot be tracked");
        }
        this.parcel = parcel;
        parcel.updateCurrentStage(new ParcelStage("Packed"));
        this.headStage = parcel.getCurrentStage();
        initializeDefaultStages();
    }

    private void initializeDefaultStages(){
        ParcelStage shipped = new ParcelStage("Shipped");
        ParcelStage inTransit = new ParcelStage("In Transit");
        ParcelStage delivered = new ParcelStage("Delivered");

        headStage.setNextStage(shipped);
        shipped.setNextStage(inTransit);
        inTransit.setNextStage(delivered);
    }

    public void trackParcel() throws ParcelLostException{
        if(parcel.isLost()){
            throw new ParcelLostException("Lost parcel cannot be tracked");
        }
        if (headStage == null) {
            System.out.println("Tracking data unavailable.");
            return;
        }
        System.out.println("Tracking Parcel ID: " + parcel.getParcelID());
        ParcelStage current = headStage;
        while (current != null) {
            System.out.print(" -> " + current.getStageName());
            current = current.getNextStage();
        }
        System.out.println();
        System.out.println("Tracking completed. Parcel "+parcel.getParcelID()+" delivered to "+parcel.getParcelReciever()+" successfully");
    }

    public void addCheckpoint(String afterStage, String newStage) throws ParcelLostException{
        if(parcel.isLost()){
            throw new ParcelLostException("Lost parcel cannot be tracked");
        }
        ParcelStage current = headStage;
        while (current != null) {
            if (current.getStageName().equalsIgnoreCase(afterStage)) {
                ParcelStage checkpoint = new ParcelStage(newStage);
                checkpoint.setNextStage(current.getNextStage());
                current.setNextStage(checkpoint);
                System.out.println("Checkpoint added successfully.");
                return;
            }
            current = current.getNextStage();
        }
        System.out.println("Stage not found. Checkpoint not added.");
    }

    public void markParcelLost() {
        if(parcel.isLost()){
            System.out.println("Parcel is already marked as lost");
            return;
        }
        headStage = null;
        parcel.updateCurrentStage(null);
        parcel.setIsLost(true);
        System.out.println("Parcel marked as lost.");
    }
}
