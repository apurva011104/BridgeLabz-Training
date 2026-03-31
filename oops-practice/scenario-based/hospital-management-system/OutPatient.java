public class OutPatient extends Patient{

    private double consultationFee;

    public OutPatient( String ID, String name, int age, String ailment, double consultationFee) {
        super(ID, name, age, ailment);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill(){
        return consultationFee;
    }

    @Override
    public void displayInfo(){
        System.out.println("Patient details:");
        System.out.println("ID: "+getID());
        System.out.println("Name: "+getName());
        System.out.println("Age: "+getAge());
        System.out.println("Ailment: "+getAilment());
        System.out.printf("Consultation Fee: %.2f INR%n",consultationFee);

    }
    
}
