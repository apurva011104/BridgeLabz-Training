public class InvalidPhoneNumberException extends Exception {
    @Override
    public String getMessage(){
        return "Invalid phone number. Phone number length must be only 10 digits";
    }
}
