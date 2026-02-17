public class Contact{

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) throws InvalidDetailsException {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    //Getters and setters
    public void setFirstName(String firstName) throws InvalidDetailsException{
        if(!ValidationUtils.validateDetails(firstName)){
            throw new InvalidDetailsException("Invalid first name");
        }
        this.firstName=firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName) throws InvalidDetailsException {
        if(!ValidationUtils.validateDetails(lastName)){
            throw new InvalidDetailsException("Invalid last name");
        }
        this.lastName=lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setAddress(String address) throws InvalidDetailsException {
        if(!ValidationUtils.validateDetails(address)){
            throw new InvalidDetailsException("Invalid address");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city)throws InvalidDetailsException {
        if(!ValidationUtils.validateDetails(city)){
            throw new InvalidDetailsException("Invalid city");
        }
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setState(String state) throws InvalidDetailsException {
        if(!ValidationUtils.validateDetails(state)){
            throw new InvalidDetailsException("Invalid state");
        }
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public void setZip(String zip) throws InvalidDetailsException {
        if(!ValidationUtils.validateZIP(zip)){
            throw new InvalidDetailsException("ZIP code must be 6 digits only");
        }
        this.zip = zip;
    }

    public String getZip(){
        return zip;
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidDetailsException {
        if(!ValidationUtils.validatePhoneNumber(phoneNumber)){
            throw new InvalidDetailsException("Phone Number must contain 10 digits only");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setEmail(String email) throws InvalidDetailsException{
        if(!ValidationUtils.validateEmail(email)){
            throw new InvalidDetailsException("Please enter valid email");
        }
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }
        Contact anotherContact = (Contact) obj;
        return anotherContact.firstName.equalsIgnoreCase(this.firstName) && anotherContact.lastName.equalsIgnoreCase(lastName);
    }
    

    
}
