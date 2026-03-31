import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;

public class Hospital implements HospitalService {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm")
                    .withResolverStyle(ResolverStyle.STRICT);

    private String name;
    private List<Patient> patientsRecord;
    private List<Doctor> doctorsRecord;
    private List<Appointment> appointmentsRecord;

    public Hospital(String name) {
        this.name = name;
        this.patientsRecord = new ArrayList<>();
        this.doctorsRecord = new ArrayList<>();
        this.appointmentsRecord = new ArrayList<>();
    }

    /*-------------------- Consultation Fee Calculator --------------------*/
    @Override
    public double calculateConsultationFee(double consultationFee, int patientAge) {
        if (patientAge >= 60) {
            return consultationFee * 0.75;
        }
        return consultationFee;
    }

    /*--------------------------- ID GENERATION -------------------------------------*/
    private boolean isDoctorIDPresent(String id) {
        for (Doctor doctor : doctorsRecord) {
            if (doctor.getID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPatientIDPresent(String id) {
        for (Patient patient : patientsRecord) {
            if (patient.getID().equals(id)) {
                return true;
            }
        }
        return false;
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
        while (prefix.equals("DOC")?isDoctorIDPresent(id):isPatientIDPresent(id));
        return id;
    }

    /*------------------------- CREATE OPERATIONS-------------------------*/
    @Override
    public Patient addPatient(String name, int age) {
        Patient patient = new Patient(generateID("PNT"), name, age);
        patientsRecord.add(patient);
        return patient;
    }

    @Override
    public Doctor addDoctor(String name, String specialization, double consultationFee) {
        Doctor doctor = new Doctor(generateID("DOC"), name, specialization, consultationFee);
        doctorsRecord.add(doctor);
        return doctor;
    }

    /*-------------------------READ OPERATIONS-------------------------*/
    @Override
    public void displayPatientRecord() {
        System.out.println("--------------------------------------------");
        System.out.println("Patients Record: ");
        for (Patient p : patientsRecord) {
            p.displayInformation();
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }

    @Override
    public void displayDoctorRecord() {
        System.out.println("--------------------------------------------");
        System.out.println("Doctors Record: ");
        for (Doctor d : doctorsRecord) {
            d.displayInformation();
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }

    @Override
    public void viewMedicalHistory(Patient patient) {
        System.out.println("---------------------------------------------");
        System.out.println("Medical History of " + patient.getName());
        for (MedicalRecord record : patient.getMedicalHistory()) {
            record.displayRecord();
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }

    /*-------------------------UPDATE OPERATIONS-------------------------*/
    @Override
    public Appointment bookAppointment(Patient patient, Doctor doctor, String datetime)throws AppointmentNotAvailableException {
        if (!patientsRecord.contains(patient)) {
            System.out.println("Patient not registered");
            return null;
        }
        if (!doctorsRecord.contains(doctor)) {
            System.out.println("Doctor not registered");
            return null;
        }
        try {
            LocalDateTime dateTime = LocalDateTime.parse(datetime, formatter);
            for (Appointment a : appointmentsRecord) {
                if (a.getDoctor().equals(doctor) && a.getAppointmentDateTime().equals(dateTime) && !a.getCancellationStatus()) {
                    throw new AppointmentNotAvailableException();
                }
            }
            Appointment appointment = new Appointment(patient, doctor, dateTime);
            appointmentsRecord.add(appointment);
            doctor.updateAvailability(false);

            return appointment;

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date-time format");
            return null;
        }
    }

    @Override
    public void cancelAppointment(Appointment appointment) {
        if(appointment==null || !appointmentsRecord.contains(appointment)){
            System.out.println("Appointment not found in the record");
            return;
        }
        if(appointment.getCancellationStatus()){
            System.out.println("Appointment is cancelled already");
            return;
        }
        appointment.getDoctor().updateAvailability(true);
        appointment.updateCancellationStatus(true);
        System.out.println("Appointment cancelled");
    }

    @Override
    public void addMedicalRecord(Patient patient, Appointment appointment, List<String> ailments) {
        if (appointment==null || !appointment.getPatient().equals(patient)) {
            System.out.println("Invalid appointment details");
            return;
        }

        double fee = calculateConsultationFee( appointment.getDoctor().getConsultationFee(),patient.getAge());

        MedicalRecord record = new MedicalRecord(appointment, ailments, fee);
        patient.addMedicalRecord(record);

        System.out.println("Medical record added to patient "+patient.getID()+" medical history successfully");
    }

    /*------------------------- DELETE OPERATIONS-------------------------*/
    @Override
    public void deletePatient(Patient patient) {
        if(!patientsRecord.contains(patient)){
            System.out.println("Patient not found in the record");
            return;
        }
        patientsRecord.remove(patient);
        System.out.println("Patient removed successfully");
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        if(!doctorsRecord.contains(doctor)){
            System.out.println("Doctor not found in the record");
            return;
        }
        doctorsRecord.remove(doctor);
        System.out.println("Doctor removed successfully");
    }
}
