public class Rented implements IRentable{
    
    private Customer customer;
    private Vehicle vehicle;
    private int rentalDays;

    public Rented(Customer customer, Vehicle vehicle, int rentalDays) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    @Override
    public double calculateRentAfterApplyingDiscount(){
        double discount = discount();
        return calculateRent() * (1 - (discount *0.01));
    }

    @Override
    public double calculateRent(){
        return vehicle.getRentalPricePerDay() * rentalDays;
    }

    private double discount(){
        if(rentalDays>28)             return 35;
        if(rentalDays>21)             return 25;
        if(rentalDays>14)             return 20;
        if(rentalDays>10)             return 15;
        if(rentalDays>7)              return 10;
        if(rentalDays>4)              return 5;
        if(rentalDays>2)              return 2;
        return 0;
    }

    public void displayRentedInfo(){
        System.out.printf("Customer ID: %s, Customer Name: %s, Vehicle ID: %s, Vehicle Model: %s, Rental Days: %d, Rental Price per Day: %.2f INR, Total Price: %.2f INR, Discount %.0f%%, Price to Pay: %.2f INR%n"
            ,customer.getCustomerID(),customer.getName(),vehicle.getVehicleID(),vehicle.getModel(),rentalDays,vehicle.getRentalPricePerDay(),calculateRent(),discount(),calculateRentAfterApplyingDiscount());
    }
}
