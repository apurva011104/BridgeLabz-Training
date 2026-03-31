public class PhoneNumberAlreadyExistsException extends Exception{
    @Override
    public String getMessage(){
        return "Phone numbrer is already registered";
    }
}