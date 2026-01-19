import java.util.Scanner;

public class AddressBookMain {

    private static final Scanner SCANNER = new Scanner(System.in);
    private final AddressBook addressBook;

    public AddressBookMain() {
        addressBook = new AddressBook();
    }
    

    /*------------------------------CREATE OPERATIONS-------------------------------------*/
    public void addContact(){
        System.out.print("Enter first name: ");
        String firstName = SCANNER.nextLine().trim();
        System.out.print("Enter last name: ");
        String lastName = SCANNER.nextLine().trim();
        System.out.print("Enter address of the contact: ");
        String address = SCANNER.nextLine().trim();
        System.out.print("Enter city: ");
        String city = SCANNER.nextLine().trim();
        System.out.print("Enter state: ");
        String state = SCANNER.nextLine().trim();
        System.out.print("Enter ZIP Code: ");
        String zip = SCANNER.nextLine().trim();
        System.out.print("Enter phone number: ");
        String phoneNumber = SCANNER.nextLine().trim();
        System.out.print("Enter email id: ");
        String email= SCANNER.nextLine().trim();
        addressBook.addContact(firstName, lastName, address, city, state, zip, phoneNumber, email);
    }

    /*-----------------------UPDATE OPERATIONS---------------------------*/
    public void updateContact() throws InvalidContactException{
        System.out.print("Enter full name of the contact you want to update: ");
        String name = SCANNER.nextLine();
        Contact contact = addressBook.searchContact(name);
        if(contact == null){
            throw new InvalidContactException("No such contact found in the address book");
        }
        System.out.println("Current first name: "+contact.getFirstName());
        System.out.print("Do you want to update first name? Press 'Enter' if want to keep it same or enter new first name: ");
        String firstName = SCANNER.nextLine().trim();
        firstName = (firstName.length()==0)?contact.getFirstName():firstName;
        System.out.println("Current last name: "+contact.getLastName());
        System.out.print("Do you want to update last name? Press 'Enter' if want to keep it same or enter new last name: ");
        String lastName = SCANNER.nextLine().trim();
        lastName = (lastName.length()==0)?contact.getLastName():lastName;
        System.out.println("Current address: "+contact.getAddress());
        System.out.print("Do you want to update address? Press 'Enter' if want to keep it same or enter new address: ");
        String address = SCANNER.nextLine();
        address = address.length()==0?contact.getAddress():address;
        System.out.println("Current city: "+contact.getCity());
        System.out.print("Do you want to update city? Press 'Enter' if want to keep it same or enter new city: ");
        String city = SCANNER.nextLine();
        city = city.length()==0?contact.getCity():city;
        System.out.println("Current state: "+contact.getState());
        System.out.print("Do you want to update state? Press 'Enter' if want to keep it same or enter new state: ");
        String state = SCANNER.nextLine();
        state = state.length()==0?contact.getState():state;
        System.out.println("Current ZIP Code: "+contact.getZip());
        System.out.print("Do you want to update ZIP code? Press 'Enter' if want to keep it same or enter new zip code: ");
        String zip = SCANNER.nextLine();
        zip = zip.length()==0?contact.getZip():zip;
        System.out.println("Current phone number: "+contact.getPhoneNumber());
        System.out.print("Do you want to update phone number? Press 'Enter' if want to keep it same or enter new phone number: ");
        String phoneNumber = SCANNER.nextLine();
        phoneNumber = phoneNumber.length()==0?contact.getPhoneNumber():phoneNumber;
        System.out.println("Current email id: "+contact.getEmail());
        System.out.print("Do you want to update email? Press 'Enter' if want to keep it same or enter new email: ");
        String email= SCANNER.nextLine();
        email = email.length()==0? contact.getEmail() : email;

        addressBook.updateContact(contact, firstName, lastName, address, city, state, zip, phoneNumber, email);
        
    }

    /*--------------------------DELETE OPERATIONS-------------------------*/
    public void deleteContact() throws InvalidContactException{
        System.out.print("Enter full name of the contact you want to update: ");
        String name = SCANNER.nextLine();
        Contact contact = addressBook.searchContact(name);
        if(contact == null){
            throw new InvalidContactException("No such contact found in the address book");
        }
        addressBook.deleteContact(contact);
    }
}
