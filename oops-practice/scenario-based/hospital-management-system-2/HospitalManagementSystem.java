import java.util.ArrayList;
import java.util.List;

public class HospitalManagementSystem {

    public static void main(String[] args) {

        Hospital hospital = new Hospital("Global Hospital");

        Doctor d1 = hospital.addDoctor("Ava", "Cardiology", 800);
        Doctor d2 = hospital.addDoctor("Ruby", "Orthopedics", 600);

        Patient p1 = hospital.addPatient("Jennifer", 65);
        Patient p2 = hospital.addPatient("Violet", 30);

        hospital.displayDoctorRecord();
        hospital.displayPatientRecord();

        Appointment a1 = null;
        Appointment a2 = null;

        try {
            a1 = hospital.bookAppointment(p1, d1, "15-01-2026 10:30");
            a2 = hospital.bookAppointment(p2, d2, "15-01-2026 11:30");
        } catch (AppointmentNotAvailableException e) {
            System.out.println(e.getMessage());
        }
        List<String> ailments1 = new ArrayList<>();
        ailments1.add("High BP");
        ailments1.add("Chest Pain");
        ailments1.add("Diabetes");

        hospital.addMedicalRecord(p1, a1, ailments1);

        List<String> ailments2 = new ArrayList<>();
        ailments2.add("Knee Pain");
        ailments2.add("Anemia");

        hospital.addMedicalRecord(p2, a2, ailments2);

        hospital.viewMedicalHistory(p1);

        hospital.viewMedicalHistory(p2);

        hospital.cancelAppointment(a1);

        hospital.cancelAppointment(a1);

        hospital.deletePatient(p2);
        hospital.deleteDoctor(d2);

        hospital.displayPatientRecord();
        hospital.displayDoctorRecord();
    }
}
