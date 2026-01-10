public class Doctor extends Person{

    private String specialization;
    private boolean availability;

    public Doctor(String ID, String name, String specialization) {
        super(ID, name);
        this.specialization = specialization;
        this.availability = true;
    }
    

    @Override
    public void displayInfo(){
        System.out.println("Doctor details:");
        System.out.println("ID: "+getID());
        System.out.println("Name: "+getName());
        System.out.println("Specialization: "+specialization);
    }

    public boolean getAvailability() {
        return availability;
    }

    public void updateAvailability(boolean availability) {
        this.isAvailable = availability;
    }
}
