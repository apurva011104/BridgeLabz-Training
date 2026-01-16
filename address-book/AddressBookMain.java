import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain{

    private static final Scanner SCANNER = new Scanner(System.in);
    private List<Contacts> contacts;

    public AddressBookMain() {
        this.contacts = new ArrayList<>();
    }


    /*------------------------------CREATE OPERATIONS-------------------------------------*/
    public Contacts addContact(){
        System.out.print("Enter first name: ");
        String firstName = SCANNER.nextLine();
        System.out.print("Enter last name: ");
        String lastName = SCANNER.nextLine();
        System.out.print("Enter address of the contact: ");
        String address = SCANNER.nextLine();
        System.out.print("Enter city: ");
        String city = SCANNER.nextLine();
        System.out.print("Enter state: ");
        String state = SCANNER.nextLine();
        System.out.print("Enter ZIP Code: ");
        String zip = SCANNER.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = SCANNER.nextLine();
        System.out.print("Enter email id: ");
        String email= SCANNER.nextLine();

        try {
            Contacts contact = new Contacts(firstName,lastName,address,city,state,zip,phoneNumber,email);
            contacts.add(contact);
            System.out.println("Contact added successfully");
            return contact;
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /*-----------------------------------------READ OPERATIONS-----------------------------------------*/
    public void displayContactInformation(Contacts contact) throws InvalidContactException{
        if(contact == null){
            throw new InvalidContactException("Invalid contact");
        }
        System.out.printf("Contact name: %s %s%n",contact.getFirstName(),contact.getLastName());
        System.out.println("Address: "+contact.getAddress());
        System.out.println("City: "+contact.getCity());
        System.out.println("State: "+contact.getState());
        System.out.println("ZIP Code: "+contact.getZip());
        System.out.println("Phone Number: "+contact.getPhoneNumber());
        System.out.println("Email ID: "+contact.getEmail());
    }

    /*-----------------------------------UPDATE OPERATIONS----------------------------------------*/
    public void updateContact(Contacts contact) throws InvalidContactException {
        if(contact==null){
            throw new InvalidContactException("Invalid contact");
        }
        System.out.println("Current first name: "+contact.getFirstName());
        System.out.print("Enter updated first name: ");
        String firstName = SCANNER.nextLine();
        System.out.println("Current last name: "+contact.getLastName());
        System.out.print("Enter updated last name: ");
        String lastName = SCANNER.nextLine();
        System.out.println("Current address: "+contact.getAddress());
        System.out.print("Enter updated address of the contact: ");
        String address = SCANNER.nextLine();
        System.out.println("Current city: "+contact.getCity());
        System.out.print("Enter updated city: ");
        String city = SCANNER.nextLine();
        System.out.println("Current state: "+contact.getState());
        System.out.print("Enter updated state: ");
        String state = SCANNER.nextLine();
        System.out.println("Current ZIP Code: "+contact.getZip());
        System.out.print("Enter updated ZIP Code: ");
        String zip = SCANNER.nextLine();
        System.out.println("Current phone number: "+contact.getPhoneNumber());
        System.out.print("Enter updated phone number: ");
        String phoneNumber = SCANNER.nextLine();
        System.out.println("Current email id: "+contact.getEmail());
        System.out.print("Enter updated email id: ");
        String email= SCANNER.nextLine();

        try {
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setAddress(address);
            contact.setCity(city);
            contact.setState(state);
            contact.setZip(zip);
            contact.setPhoneNumber(phoneNumber);
        } 
        catch (InvalidPhoneNumberException e) {
            System.out.println(e);
        }
        try {
            contact.setEmail(email);
            System.out.println("Contact updated successfully");
        }
        catch (InvalidEmailException e) {
            System.out.println(e);
        }
    }
}