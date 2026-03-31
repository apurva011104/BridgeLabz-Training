import java.util.List;

public interface HospitalService extends ConsultationFeeCalculator{

    Patient addPatient(String name, int age);
    Doctor addDoctor(String name, String specialization, double consultationFee);

    void displayPatientRecord();
    void displayDoctorRecord();
    void viewMedicalHistory(Patient patient);

    void addMedicalRecord(Patient patient, Appointment appointment, List<String> ailments);
    Appointment bookAppointment(Patient patient, Doctor doctor, String datetime) throws AppointmentNotAvailableException;
    void cancelAppointment(Appointment appointment);

    void deletePatient(Patient patient);
    void deleteDoctor(Doctor doctor);
    
}
