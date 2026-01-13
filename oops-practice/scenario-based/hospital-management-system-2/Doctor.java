public class Doctor extends Person{

    private String specialization;
    private boolean availability;
    private double consultationFee;

    public Doctor(String ID, String name, String specialization, double consultationFee) {
        super(ID, name);
        this.specialization = specialization;
        this.availability = true;
        this.consultationFee = consultationFee;
    }
    

    @Override
    public void displayInformation(){
        System.out.println("Doctor details:");
        System.out.println("ID: "+getID());
        System.out.println("Name: "+getName());
        System.out.println("Specialization: "+specialization);
        System.out.printf("Consultation Fee: %.2f INR%n",consultationFee);
    }

    public boolean getAvailability() {
        return availability;
    }

    public void updateAvailability(boolean availability) {
        this.availability = availability;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void updateConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

}
