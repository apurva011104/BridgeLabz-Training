import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private final List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    /*------------------------------CREATE OPERATIONS-------------------------------------*/
    public void addContact(String firstName , String lastName, String address , String city , String state, String zip, String phoneNumber , String email ){
        try {
            Contact contact = new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);
            contacts.add(contact);
            System.out.println("Contact added successfully");
        } 
        catch (InvalidDetailsException e) {
            System.out.print("Unable to add contact. ");
            System.out.println(e);
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
            System.out.println(e);
            System.out.println("Only some of the contact details are updated");
        }
    }
    
    /*----------------------DELETE OPERATIONS------------------------*/
    public void deleteContact(Contact contact){
        contacts.remove(contact);
        System.out.println("Contact removed successfuly");
    }
}
