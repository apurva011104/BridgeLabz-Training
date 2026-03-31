public class MobilePhone {

    String brand;
    String model;
    double price;

    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    //Method to display phone details
    public void displayDetails(){
        System.out.println("Brand of the mobile: "+brand);
        System.out.println("Model of the mobile: "+model);
        System.out.printf("Price of the mobile: %.2f%n",price);
        System.out.println("------------------------------------------------");
    }
    
    public static void main(String[] args) {

        MobilePhone mobile1 = new MobilePhone("VIVO","VIVO V29",15999.0);
        MobilePhone mobile2 = new MobilePhone("ONE PLUS","ONE PLUS nord4",39999.0);
        MobilePhone mobile3 = new MobilePhone("APPLE","iphone pro16",79999.0);

        mobile1.displayDetails();
        mobile2.displayDetails();
        mobile3.displayDetails();

    }
}
