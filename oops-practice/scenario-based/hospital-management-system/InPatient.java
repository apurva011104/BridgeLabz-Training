public class InPatient extends Patient{

    private int daysAdmitted;
    private double chargePerDay;

    public InPatient( String ID, String name, int age, String ailment, int daysAdmitted, double dailyCharge ) {
        super(ID, name, age, ailment);
        this.daysAdmitted = daysAdmitted;
        this.chargePerDay = dailyCharge;
    }
    
    @Override
    public double calculateBill(){
        return daysAdmitted * chargePerDay;
    }

    @Override
    public void displayInfo(){
        System.out.println("Patient details:");
        System.out.println("ID: "+getID());
        System.out.println("Name: "+getName());
        System.out.println("Age: "+getAge());
        System.out.println("Ailment: "+getAilment());
        System.out.println("Number of Days Admitted: "+daysAdmitted);
        System.out.printf("Stay Charge Per Day: %.2f INR%n",chargePerDay);
    }
}
