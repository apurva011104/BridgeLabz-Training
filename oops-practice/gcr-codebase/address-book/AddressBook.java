import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private String name;
    private final List<Contact> contacts;

    public AddressBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*------------------------------CREATE OPERATIONS-------------------------------------*/
    public void addContact(String firstName , String lastName, String address , String city , String state, String zip, String phoneNumber , String email ){
        try {
            Contact contact = new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);
            contacts.add(contact);
            System.out.println("Contact added successfully");
        } 
        catch (InvalidDetailsException e) {
            System.out.println("Unable to add contact. "+e.getMessage());
        }
    }
    
    /*----------------------READ OPERATIONS--------------------------*/
    public Contact searchContact(String name){
        for(Contact contact: contacts){
            String fullName = contact.getFirstName()+" "+contact.getLastName();
            if(fullName.equalsIgnoreCase(name)){
                return contact;
            }
        }
        return null;
    }

    /*----------------------UPDATE OPERATIONS------------------------*/
    public void updateContact(Contact contact,String firstName , String lastName, String address , String city , String state, String zip, String phoneNumber , String email ){
        try {
            new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setAddress(address);
            contact.setCity(city);
            contact.setState(state);
            contact.setZip(zip);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmail(email);
            System.out.println("Contact updated successfully.");
        } 
        catch (InvalidDetailsException e) {
            System.out.println("Invalid contact details");
        }
    }
    
    /*----------------------DELETE OPERATIONS------------------------*/
    public void deleteContact(Contact contact){
        contacts.remove(contact);
        System.out.println("Contact removed successfuly");
    }

}
