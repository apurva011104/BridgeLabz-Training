public class TimberTransport extends GoodsTransport {
    
    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportID, String transportDate, int transportRating, float timberLength, float timberRadius, String timberType, float timberPrice) {
        super(transportID, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    /*---------------------GETTERS------------------------*/
    public float getTimberLength() {
        return timberLength;
    }

    public float getTimberRadius() {
        return timberRadius;
    }

    public String getTimberType() {
        return timberType;
    }

    public float getTimberPrice() {
        return timberPrice;
    }

    /*---------------------SETTERS------------------------*/
    public void setTimberLength(float timberLength) {
        this.timberLength = timberLength;
    }

    public void setTimberRadius(float timberRadius) {
        this.timberRadius = timberRadius;
    }

    public void setTimberType(String timberType) {
        this.timberType = timberType;
    }

    public void setTimberPrice(float timberPrice) {
        this.timberPrice = timberPrice;
    }

    /*---------------------CONCRETE IMPLEMENTATION OF PARENT CLASS ABSTRACT METHODS------------------------*/
    @Override
    public String vehicleSelection(){
        float area = area();

        if(area<250){
            return "Truck";
        }
        else if(area<=400){
            return "Lorry";
        }
        else{
            return "MonsterLorry";
        }
    }

    @Override
    public float calculateTotalCharge(){
        float volume = volume();
        float timberTypeRate = applyRate();
        float price = volume * timberPrice * timberTypeRate;
        float tax = price * 0.3f; 
        float discount = price * discountPercentage() / 100.0f;
        float totalCharge = price + vehiclePrice() + tax - discount;
        return totalCharge;
    }

    /*---------------------HELPER METHODS------------------------*/
    private float area(){
        return  2.0f * 3.147f * timberRadius * timberLength;
    }

    private float volume(){
        return 3.147f * timberRadius * timberRadius * timberLength;
    }

    private float applyRate(){
        if(timberType.equalsIgnoreCase("Premium")){
            return 0.25f;
        }
        else if (timberType.equalsIgnoreCase("NonPremium")) {
            return 0.15f;
        }
        else{
            return 0.0f;
        }
    }

    private float vehiclePrice(){
        String vehicleType = vehicleSelection();
        if(vehicleType.equalsIgnoreCase("truck")){
            return 1000.0f;
        }
        else if (vehicleType.equalsIgnoreCase("lorry")) {
            return 1700.0f;
        }
        else{
            return 3000.0f;
        }
    }

    private float discountPercentage(){
        int transportRating = getTransportRating();

        if(transportRating==5){
            return 20.0f;
        }
        else if(transportRating == 3 || transportRating == 4){
            return 10.0f;
        }
        else{
            return 0.0f;
        }
    }
}
