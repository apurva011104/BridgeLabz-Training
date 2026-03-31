import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    
    private int age;
    private List<MedicalRecord> medicalHistory;

    public Patient( String ID, String name, int age) {
        super(ID, name);
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<MedicalRecord> getMedicalHistory() {
        return medicalHistory;
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalHistory.add(medicalRecord);
    }

    public void displayInformation(){
        System.out.printf("Patient ID: %s, Patient Name: %s, Age: %d",getID(), getName(), getAge());
    }
}
