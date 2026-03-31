import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Hospital{

    private static final Scanner SCAN = new Scanner(System.in);
    private String name;
    private Set<String> patientIDs;
    private Set<String> doctorIDs;
    private ArrayList<Patient> patientRecord;
    private ArrayList<Doctor> doctorRecord;
    private Map<Patient,Doctor> assignedRecord;

    public Hospital(String name) {
        this.name = name;
        this.patientIDs = new HashSet<>();
        this.doctorIDs = new HashSet<>();
        this.patientRecord = new ArrayList<>();
        this.doctorRecord = new ArrayList<>();
        this.assignedRecord = new HashMap<>();
    }
    
    private String generateID(String prefix){
        String id;
        do { 
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<12;i++){
                int charType=(int)(Math.random()*3);

                switch (charType){
                    case 0:
                        sb.append((char)((int)(Math.random()*26)+'a'));
                        break;
                    case 1:
                        sb.append((char)((int)(Math.random()*26)+'A'));
                        break;
                    case 2:
                        sb.append((char)((int)(Math.random()*10)+'0'));
                        break;
                }
            }
            id=prefix+sb.toString();
        } 
        while (prefix.equals("DOC")?doctorIDs.contains(id):patientIDs.contains(id));
        return id;
    }

    public String getName() {
        return name;
    }

    /*----------------------CREATE OPERATIONS-------------------------------------*/

    public Patient addInPatient(String name, int age, String ailment, int daysAdmitted, double dailyCharge ){
        String id = generateID("INP");
        Patient patient = new InPatient(id, name, age, ailment, daysAdmitted, dailyCharge);
        patientIDs.add(id);
        patientRecord.add(patient);
        return patient;
    }

    public Patient addOutPatient(String name, int age, String ailment, double consultationFee){
        String id = generateID("OUP");
        Patient patient = new OutPatient(id, name, age, ailment, consultationFee);
        patientIDs.add(id);
        patientRecord.add(patient);
        return patient;
    }

    public Doctor addDoctor(String name, String specialization){
        String id = generateID("DOC");
        Doctor doctor = new Doctor(id, name, specialization);
        doctorIDs.add(id);
        doctorRecord.add(doctor);
        return doctor;
    }
    
    /*----------------------READ OPERATIONS--------------------------------------*/
    public void displayPatientRecord(){
        if(patientRecord.isEmpty()){
            System.out.println("Patient record is empty");
            return;
        }
        System.out.println("Patient Record: ");
        for(Patient patient : patientRecord){
            patient.displayInfo();
        }
    }

    public void displayDoctorRecord(){
        if(doctorRecord.isEmpty()){
            System.out.println("Doctor record is empty");
            return;
        }
        System.out.println("Doctor Record: ");
        for(Doctor doctor: doctorRecord){
            doctor.displayInfo();
        }
    }

    public void displayAssignedRecord(){
        if(assignedRecord.isEmpty()){
            System.out.println("Assigned record is empty");
            return;
        }
        int idx=1;
        System.out.println("Assigned Record: ");
        for(Map.Entry<Patient,Doctor> entry: assignedRecord.entrySet()){
            Patient patient = entry.getKey();
            Doctor doctor = entry.getValue();
            System.out.printf("%d. Patient ID: %s, Patient name: %s, Assigned doctor ID: %s, Assigned doctor name: %s%n",idx, patient.getID(), patient.getName(), doctor.getID(), doctor.getName());
            idx++;
        }
    }

    public void displayBill(Patient patient){
        IPayable iPayable = patient;
        
        System.out.print("Patient with ID "+patient.getID()+" and name"+patient.getName()+" ");
        Bill bill = new Bill(iPayable);
        bill.generateBill();
    }

    /*-------------------------UPDATE OPERATIONS--------------------------------*/

    //Method to assign doctors to patient
    public void assignDoctor(Patient patient){
        if(!patientIDs.contains(patient.getID())){
            System.out.println("No such patient found in the record");
            return;
        }
        if(assignedRecord.containsKey(patient)){            //Checking if patient already has a doctor
            System.out.println("Doctor has been already assigned for the patient");
            return;
        }

        boolean isAssignmentSuccessful = false;

        for(Doctor doctor: doctorRecord){
            if(doctor.getAvailability()){
                doctor.updateAvailability(false);
                isAssignmentSuccessful=true;
                assignedRecord.putIfAbsent(patient, doctor);
                System.out.println("Doctor "+doctor.getName()+" assigned to patient "+patient.getName()+" successfully");
                break;
            }
        }

        if(!isAssignmentSuccessful){
           System.out.println("No doctor availale at the moment to attend "+patient.getName());
        }
    }

    //Method to unassign a doctor
    public void unassignDoctor(Patient patient){

        if(!patientIDs.contains(patient.getID())){
            System.out.println("No such patient found in the record");
            return;
        }
        if(!assignedRecord.containsKey(patient)){            //Checking if patient has a doctor assigned or not
            System.out.println("No doctor has been assigned to the patient");
            return;
        }
        
        Doctor doctor=assignedRecord.get(patient);
        doctor.updateAvailability(true);
        assignedRecord.remove(patient);
        System.out.println("Doctor "+doctor.getName()+" has been unassigned to patient "+patient.getName());
    }

    /*-------------------------DELETE OPERATIONS--------------------------------*/

    //Method to remove patient
    public void removePatient(String patientId){
        if(!patientIDs.contains(patientId)){
            System.out.println("No such patient found in the record");
            return;
        }

        Patient patientToRemove = null;
        for(Patient patient: patientRecord){
            if(patient.getID().equals(patientId)){
                patientToRemove = patient;
                break;
            }
        }
        if(assignedRecord.containsKey(patientToRemove)){
            assignedRecord.get(patientToRemove).updateAvailability(true);
            assignedRecord.remove(patientToRemove);
        }
        patientRecord.remove(patientToRemove);
        patientIDs.remove(patientId);
        System.out.println("Patient removed successfully");
    }

    //Method to remove doctor
    public void removeDoctor(String doctorId){
        if(!doctorIDs.contains(doctorId)){
            System.out.println("No such doctor found in the record");
            return;
        }
        Doctor doctorToRemove=null;
        for(Doctor doctor: doctorRecord){
            if(doctor.getID().equals(doctorId)){
                doctorToRemove = doctor;
                break;
            }
        }
        for(Map.Entry<Patient,Doctor> entry: assignedRecord.entrySet()){
            if(entry.getValue().equals(doctorToRemove)){
                Patient patient = entry.getKey();
                unassignDoctor(patient);
                doctorRecord.remove(doctorToRemove);
                assignDoctor(patient);
                break;
            }
        }
        doctorIDs.remove(doctorId);
        System.out.println("Doctor removed successfully");
    }

}