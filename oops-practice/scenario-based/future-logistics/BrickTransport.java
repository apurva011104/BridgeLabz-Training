public class BrickTransport extends GoodsTransport {
    
    private final float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport( String transportID, String transportDate, int transportRating, float brickSize, int brickQuantity, float brickPrice) {
        super(transportID, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    /*---------------------GETTERS------------------------*/
    public float getBrickSize() {
        return brickSize;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }

    public float getBrickPrice() {
        return brickPrice;
    }

    /*---------------------SETTERS------------------------*/
    public void setBrickQuantity(int brickQuantity) {
        this.brickQuantity = brickQuantity;
    }

    public void setBrickPrice(float brickPrice) {
        this.brickPrice = brickPrice;
    }

    /*---------------------CONCRETE IMPLEMENTATION OF PARENT CLASS ABSTRACT METHODS------------------------*/
    @Override
    public String vehicleSelection(){
        if(brickQuantity<300){
            return "Truck";
        }
        else if(brickQuantity<=500){
            return "Lorry";
        }
        else{
            return "MonsterLorry";
        }
    }

    @Override
    public float calculateTotalCharge(){
        float price = brickPrice * brickQuantity;
        float tax = price * 0.3f;
        float discount = price * discountPercentage() / 100.0f;
        float totalCharge = price + vehiclePrice() + tax - discount;
        return totalCharge;

    }

    /*---------------------HELPER METHODS------------------------*/
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
