import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain{

    private static final Scanner SCANNER = new Scanner(System.in);
    private List<Contacts> contacts;

    public AddressBookMain() {
        this.contacts = new ArrayList<>();
    }
    
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
            return contact;
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

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

}