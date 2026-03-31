public class AppointmentNotAvailableException extends Exception {

    @Override
    public String getMessage() {
        return "Appointment not available at the selected time.";
    }
    
}
