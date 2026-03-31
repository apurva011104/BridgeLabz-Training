public abstract class GoodsTransport {
    
    protected String transportID;
    protected String transportDate;
    protected int transportRating;

    public GoodsTransport(String transportID, String transportDate, int transportRating) {
        this.transportID = transportID;
        this.transportDate = transportDate;
        this.transportRating = transportRating;
    }

    /*---------------------GETTERS------------------------*/
    public String getTransportID() {
        return transportID;
    }

    public String getTransportDate() {
        return transportDate;
    }

    public int getTransportRating() {
        return transportRating;
    }

    /*---------------------SETTERS------------------------*/
    public void setTransportID(String transportID) {
        this.transportID = transportID;
    }

    public void setTransportDate(String transportDate) {
        this.transportDate = transportDate;
    }

    public void setTransportRating(int transportRating) {
        this.transportRating = transportRating;
    }
    
    /*---------------------ABSTRACT METHODS------------------------*/
    abstract public String vehicleSelection();

    abstract public float calculateTotalCharge();

}
