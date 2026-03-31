
import java.util.PriorityQueue;

public class HospitalTriageSystem {
    class Patient{
        String patientName;
        int priority;

        public Patient(String patientName, int priority) {
            this.patientName = patientName;
            this.priority = priority;
        }
        
    }

    PriorityQueue<Patient> patients;

    public HospitalTriageSystem() {
        patients = new PriorityQueue<>((p,q)->Integer.compare(q.priority,p.priority));
    }

    public void addPatient(String name, int priority){
        Patient patient = new Patient(name, priority);
        patients.add(patient);
    }
    
    public void treatPatients(){
        for(Patient patient: patients){
            System.out.printf("%s, ",patient.patientName);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        HospitalTriageSystem hospital = new HospitalTriageSystem();

        hospital.addPatient("John",3);
        hospital.addPatient("Alice",5 );
        hospital.addPatient("Bob", 2);

        hospital.treatPatients();
    }
}
