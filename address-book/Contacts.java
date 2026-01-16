

public class Contacts {

    private String[] name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contacts(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) throws InvalidPhoneNumberException, InvalidEmailException{
        if(!validatePhoneNumber(phoneNumber)){
            throw new InvalidPhoneNumberException("Phone Number must contain 10 digits only");
        }
        if(!validateEmail(email)){
            throw new InvalidEmailException("Please enter valid email");
        }
        this.name = new String[]{firstName,lastName};
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //Getters and setters
    public void setFirstName(String firstName){
        this.name[0]=firstName;
    }

    public String getFirstName(){
        return this.name[0];
    }

    public void setLastName(String lastName){
        this.name[1]=lastName;
    }

    public String getLastName(){
        return this.name[1];
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return this.address;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return this.city;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }

    public void setZip(String zip){
        this.zip = zip;
    }

    public String getZip(){
        return this.zip;
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException{
        if(!validatePhoneNumber(phoneNumber)){
            throw new InvalidPhoneNumberException("Phone Number must contain 10 digits only");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setEmail(String email) throws InvalidEmailException{
        if(!validateEmail(email)){
            throw new InvalidEmailException("Please enter valid email");
        }
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    /*--------------------------Validator methods--------------------------------*/
    private static boolean validatePhoneNumber(String phoneNumber){
        if(phoneNumber.length()!=10){
            return false;
        }
        for(char digit: phoneNumber.toCharArray()){
            if(!Character.isDigit(digit)){
                return false;
            }
        }
        return true;
    }

    private static boolean validateEmail(String email){
        boolean atTheRateOccurrence = false;
        final String SYMBOLS = "_.+-@";

        for(char ch: email.toCharArray()){
            if(ch=='@'){
                if(atTheRateOccurrence){
                    return false;
                }
                atTheRateOccurrence=true;
            }
            if(!Character.isAlphabetic(ch) && !Character.isDigit(ch) && !SYMBOLS.contains(ch+"")){
                return false;
            }
        }

        return atTheRateOccurrence;
    }

}
