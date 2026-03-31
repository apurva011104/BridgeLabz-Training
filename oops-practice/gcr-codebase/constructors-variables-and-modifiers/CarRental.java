public class CarRental {

    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double PRICE_PER_DAY = 700.00; 
    //Constructor to create car rental object
    CarRental(String customerName, String carModel, int rentalDays) {
        setCustomerName(customerName);
        setCarModel(carModel);
        setRentalDays(rentalDays);
    }

    //Getters and Setters
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public void setCarModel(String carModel){
        this.carModel = carModel;
    }

    public void setRentalDays(int rentalDays){
        this.rentalDays = rentalDays;
    }

    public String getCustomerName(){
        return customerName;
    }

    public String getCarModel(){
        return carModel;
    }

    public int getRentalDays(){
        return rentalDays;
    }

    public double getPricePerDay(){
        return PRICE_PER_DAY;
    }

    //Method to calculate calculate total cost
    private double calculateTotalCost(){
        return getRentalDays()*getPricePerDay();
    }

    //Method to display total cost
    public void displayTotalCost(){
        double totalCost = calculateTotalCost();
        System.out.printf("Total cost: %.2f%n",totalCost);
    }
    
    //Method to display details
    public void displayDetails(){
        System.out.println("Customer name: "+getCustomerName());
        System.out.println("Car Model: "+getCarModel());
        System.out.println("Rental Days: "+getRentalDays());
        System.out.println("-----------------------------------------------------");
    }

    public static void main(String[] args) {
        CarRental car = new CarRental("Ava", "BMW", 4);
        car.displayDetails();
        car.displayTotalCost();
    }
}
