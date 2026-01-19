public class Contact{

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) throws InvalidPhoneNumberException, InvalidEmailException, InvalidZIPException{
        if(!ValidationUtils.validatePhoneNumber(phoneNumber)){
            throw new InvalidPhoneNumberException("Phone Number must contain 10 digits only");
        }
        if(!ValidationUtils.validateEmail(email)){
            throw new InvalidEmailException("Please enter valid email");
        }
        if(!ValidationUtils.validateZIP(zip)){
            throw new InvalidZIPException("Please enter a valid ZIP code");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //Getters and setters
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public void setZip(String zip) throws InvalidZIPException{
        if(!ValidationUtils.validateZIP(zip)){
            throw new InvalidZIPException("Please enter a valid ZIP code");
        }
        this.zip = zip;
    }

    public String getZip(){
        return zip;
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException{
        if(!ValidationUtils.validatePhoneNumber(phoneNumber)){
            throw new InvalidPhoneNumberException("Phone Number must contain 10 digits only");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setEmail(String email) throws InvalidEmailException{
        if(!ValidationUtils.validateEmail(email)){
            throw new InvalidEmailException("Please enter valid email");
        }
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }
    

}
