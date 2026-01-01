public class Patient {

    //Static variable
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    //Instance variables
    private final String patientID;     //Final variable
    private String name;
    private int age;
    private String ailment;

    //Constructor to create Patient object
    public Patient(String patientID, String name, int age, String ailment) {
        //Use of this keyword in constructor
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    //Getters and setters
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setAilment(String ailment){
        this.ailment = ailment;
    }
    public String getPatientID(){
        return patientID;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getAilment(){
        return ailment;
    }

    public static String getHospitalName(){
        return hospitalName;
    }

    //Static method to get total patients
    public static int getTotalPatients(){
        return totalPatients;
    }

    //Static method to display total patients
    public static void displayTotalPatients(){
        System.out.println("Total Patients Admitted: "+getTotalPatients());
    }

    //Instance method to display patient details
    public void displayPatientDetails(){
        if(this instanceof Patient){
            System.out.println("Hospital Name: "+hospitalName);
            System.out.println("Patient ID: "+patientID);
            System.out.println("Name: "+name);
            System.out.println("Age: "+age);
            System.out.println("Ailment: "+ailment);
        }
    }
    
    //Main method for testing
    public static void main(String[] args) {
        
        Patient patient1 = new Patient("P001","Lathika",30,"Flu");
        Patient patient2 = new Patient("P002","Lidiya",45,"Fracture");

        displayTotalPatients();

        patient1.displayPatientDetails();
        patient2.displayPatientDetails();
    }
}
