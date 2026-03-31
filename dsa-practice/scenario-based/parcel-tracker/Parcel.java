public class Parcel {
    
    private final String parcelID;
    private final String parcelSender;
    private final String parcelReciever;
    private final String deliveryAddress;
    private ParcelStage currentStage;
    private boolean isLost;

    public Parcel(String parcelID, String parcelSender, String parcelReciever, String deliveryAddress) {
        this.parcelID = parcelID;
        this.parcelSender = parcelSender;
        this.parcelReciever = parcelReciever;
        this.deliveryAddress = deliveryAddress;
        this.currentStage = null;
        this.isLost = false;
    }

    public ParcelStage getCurrentStage() {
        return currentStage;
    }

    public void updateCurrentStage(ParcelStage currentStage) {
        this.currentStage = currentStage;
    }

    public String getParcelID() {
        return parcelID;
    }

    public String getParcelSender() {
        return parcelSender;
    }

    public String getParcelReciever() {
        return parcelReciever;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isLost() {
        return isLost;
    }

    public void setIsLost(boolean isLost) {
        if(this.isLost == isLost){
            return;
        }
        this.isLost = isLost;
    }

}
