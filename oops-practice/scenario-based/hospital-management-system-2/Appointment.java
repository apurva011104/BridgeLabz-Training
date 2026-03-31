import java.time.LocalDateTime;

public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDateTime;
    private boolean isCancelled;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime time) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDateTime = time;
    }

    public void displayAppointmentDetails() {
       System.out.println("Appointment details: ");
       System.out.println("Patient ID: "+patient.getID());
       System.out.println("Doctor ID: "+doctor.getID());
       System.out.println("Appointment time: "+appointmentDateTime);
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public boolean getCancellationStatus() {
        return isCancelled;
    }

    public void updateCancellationStatus(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
}
