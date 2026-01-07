import java.util.HashSet;
import java.util.Set;

public class Person {

    private static Set<String> registeredPhoneNumbers= new HashSet<>();
    private final String ID;
    private String name;
    private String phoneNumber;

    public Person(String ID, String name, String phoneNumber) throws InvalidPhoneNumberException, PhoneNumberAlreadyExistsException{

        if(!validatePhoneNumber(phoneNumber)){
            throw new InvalidPhoneNumberException();
        }
        if(registeredPhoneNumbers.contains(phoneNumber)){
            throw new PhoneNumberAlreadyExistsException();
        }
        this.ID =ID;
        this.name = name;
        this.phoneNumber=phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public static boolean validatePhoneNumber(String phoneNumber){
        return phoneNumber.matches("\\d+") && phoneNumber.length()==10;
    }
}
