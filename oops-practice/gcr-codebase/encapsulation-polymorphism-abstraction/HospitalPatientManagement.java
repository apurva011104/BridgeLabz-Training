import java.util.ArrayList;
import java.util.List;

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient implements MedicalRecord {

    private final String patientId;
    private String name;
    private int age;
    private String diagnosis;
    private List<String> medicalHistory;

    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = new ArrayList<>();
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    protected int getAge() {
        return age;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History:");
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }

    // Abstract billing method
    protected abstract double calculateBill();

    // Concrete method to display Patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.printf("Total Bill: %.2f INR%n", calculateBill());
    }

}


class InPatient extends Patient {

    private int numberOfDays;
    private static final double ROOM_CHARGE_PER_DAY = 1500.0;

    public InPatient(String patientId, String name, int age, String diagnosis, int numberOfDays) {
        super(patientId, name, age, diagnosis);
        this.numberOfDays = numberOfDays;
    }

    @Override
    protected double calculateBill() {
        return numberOfDays * ROOM_CHARGE_PER_DAY;
    }

    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Number of days patient stayed: "+numberOfDays);
        System.out.printf("Room charge per day:  %.2f INR%n",ROOM_CHARGE_PER_DAY);
    }
}


class OutPatient extends Patient {

    private static final double CONSULTATION_FEE = 350.0;

    public OutPatient(String patientId, String name, int age, String diagnosis) {
        super(patientId, name, age, diagnosis);
    }

    @Override
    protected double calculateBill() {
        return CONSULTATION_FEE;
    }

    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.printf("Consultation fee: %.2f INR%n", CONSULTATION_FEE);
    }
}

// Main class for testing 
public class HospitalPatientManagement{

    public static void main(String[] args) {

        Patient patient1 = new InPatient("P1001", "Ava", 22, "Appendicitis", 5);
        Patient patient2 = new OutPatient("P2001", "Mia", 24, "Flu");

        Patient[] patients = {patient1,patient2};

        for (Patient patient : patients) {
            patient.addRecord("Initial diagnosis recorded");
            patient.addRecord("Medication prescribed");
            patient.getPatientDetails();
            patient.viewRecords();
            System.out.println();
        }
    }
}
