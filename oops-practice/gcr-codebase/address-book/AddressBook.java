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

    private boolean isDuplicate(Contact contact, Contact currentContact){
        for(Contact c : contacts){
            if(c.equals(contact) && c != currentContact){
                return true;
            }
        }
        return false;
    }

    /*------------------------------CREATE OPERATIONS-------------------------------------*/
    public void addContact(String firstName , String lastName, String address , String city , String state, String zip, String phoneNumber , String email ) throws DuplicateContactException, InvalidDetailsException{
  
        Contact contact = new Contact(firstName,lastName,address,city,state,zip,phoneNumber,email);
        if(contacts.contains(contact)){
            throw new DuplicateContactException("Contact name already exists");
        }
        contacts.add(contact);
        System.out.println("Contact added successfully");
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
    public void updateContact(Contact contact,String firstName , String lastName, String address , String city , String state, String zip, String phoneNumber , String email ) throws DuplicateContactException, InvalidDetailsException{

        Contact temp = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
        if(isDuplicate(temp, contact)){
            throw new DuplicateContactException("Contact name already exists");
        }
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
    
    /*----------------------DELETE OPERATIONS------------------------*/
    public void deleteContact(Contact contact){
        contacts.remove(contact);
        System.out.println("Contact removed successfuly");
    }

}
