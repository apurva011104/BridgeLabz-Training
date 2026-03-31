public class HospitalManagementSystem {
    public static void main(String[] args) {
        
        Hospital hospital = new Hospital("World Health Hospital");

        Patient inPatient1 = hospital.addInPatient("Serena", 25, "Fracture", 7, 1000);
        Patient inPatient2 = hospital.addInPatient("Jia", 19, "Food Poisoning", 3, 500);
        Patient outPatient1 = hospital.addOutPatient("Cassie", 6, "Fever", 240);
        Patient outPatient2 = hospital.addOutPatient("Hailey", 32, "Flu", 300);

        Doctor doctor1 = hospital.addDoctor("Ruby", "Kid specialist");
        Doctor doctor2 = hospital.addDoctor("Jane", "Dermatologist");
        Doctor doctor3 = hospital.addDoctor("Danielle", "Gastroenterologist");

        hospital.displayPatientRecord();
        System.out.println();
        hospital.displayDoctorRecord();
        System.out.println();
        hospital.displayAssignedRecord();
        System.out.println();

        hospital.displayBill(inPatient1);
        hospital.displayBill(inPatient2);
        hospital.displayBill(outPatient1);
        hospital.displayBill(outPatient2);


        hospital.assignDoctor(inPatient2);
        hospital.assignDoctor(inPatient1);
        hospital.assignDoctor(outPatient2);
        hospital.assignDoctor(outPatient1);
        hospital.assignDoctor(inPatient2);
        System.out.println();

        hospital.displayAssignedRecord();
        System.out.println();

        hospital.unassignDoctor(inPatient2);
        hospital.assignDoctor(outPatient1);
        System.out.println();

        hospital.removePatient(inPatient2.getID());
        hospital.removeDoctor(doctor1.getID());
        System.out.println();
        
        hospital.displayPatientRecord();
        System.out.println();
        hospital.displayDoctorRecord();
        System.out.println();
        hospital.displayAssignedRecord();
        System.out.println();

    }
}
