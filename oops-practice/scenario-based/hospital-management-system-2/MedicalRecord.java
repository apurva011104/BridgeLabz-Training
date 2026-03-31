import java.util.List;

public class MedicalRecord {

    private final Appointment appointment;
    private List<String> ailments;
    private double consultationFee;

    public MedicalRecord(Appointment appointment, List<String> ailments, double consultationFee) {
        this.appointment = appointment;
        this.ailments = ailments;
        this.consultationFee = consultationFee;
    }

    
    public Appointment getAppointment() {
        return appointment;
    }

    public List<String> getAilments() {
        return ailments;
    }

    public void setAilments(List<String> ailments) {
        this.ailments = ailments;
    }

    public void addAilment(String ailment) {
        ailments.add(ailment);
    }

    public void displayRecord() {
        System.out.println("Appointment Details: ");
        System.out.println("Patient: " + appointment.getPatient().getName());
        System.out.println("Doctor: " + appointment.getDoctor().getName());
        System.out.println("Date & Time: " + appointment.getAppointmentDateTime());
        System.out.println("Ailments: " + ailments);
        System.out.printf("Consultation Fee: %.2f INR%n",consultationFee);
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }
}
