public class Doctor extends Person{

    private String specialization;

    public Doctor(String ID, String name, String specialization) {
        super(ID, name);
        this.specialization = specialization;
    }

    @Override
    public void displayInfo(){
        System.out.println("Doctor details:");
        System.out.println("ID: "+getID());
        System.out.println("Name: "+getName());
        System.out.println("Specialization: "+specialization);
    }
}
