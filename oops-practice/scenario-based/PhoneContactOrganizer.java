import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class InvalidPhoneNumberException extends Exception{
    @Override
    public String getMessage(){
        return "Invalid phone number. Phone number length must be only 10 digits";
    }
}

class Contact{

    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}

public class PhoneContactOrganizer {

    private static final Scanner scan = new Scanner(System.in);
    private List<Contact> contacts;

    public PhoneContactOrganizer() {
        this.contacts =new ArrayList<>();
    }

    public static boolean validatePhoneNumber(String phoneNumber){
        return phoneNumber.matches("\\d+") && phoneNumber.length()==10;
    }

    public void addContact() throws InvalidPhoneNumberException{
        System.out.print("Enter name: ");
        String name = scan.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber=scan.next();
        if(!validatePhoneNumber(phoneNumber)){
            throw new InvalidPhoneNumberException();
        }
        for(Contact c : contacts){
            if(c.getPhoneNumber().equals(phoneNumber)){
                System.out.println("Phone number already exists");
                return;
            }
        }
        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added succesfully");

    } 

    public void deleteContact() throws InvalidPhoneNumberException{
        System.out.print("Enter phone number: ");
        String phoneNumber=scan.next();
        if(!validatePhoneNumber(phoneNumber)){
            throw new InvalidPhoneNumberException();
        }
        Contact c=null;
        for(Contact contact: contacts){
            if(contact.getPhoneNumber().equals(phoneNumber)){
                c=contact;
                break;
            }
        }
        if(c==null){
            System.out.println("No such contact exists");
            return;
        }

        contacts.remove(c);
        System.out.println("Phone number deleted succesfully");
    }

    public ArrayList<Contact> search(String searchString){
        ArrayList<Contact> foundContacts = new ArrayList<>();
        for(Contact contact: contacts){
            if(contact.getName().toLowerCase().contains(searchString) || contact.getPhoneNumber().contains(searchString)) {
                foundContacts.add(contact);
            }
        }
        return foundContacts;
    }
    public void searchContact(){
        System.out.println("Enter search string");
        String searchString = scan.next().toLowerCase();
        ArrayList<Contact> foundContacts =search(searchString);
        if(foundContacts.size()==0){
            System.out.println("No contacts found");
        }
        else{
            System.out.println("Contacts found: ");
            for(Contact contact: foundContacts){
                System.out.println("Name: "+contact.getName()+", Phone number: "+contact.getPhoneNumber());
            }
        }
    }

    public void displayContacts(){
        System.out.println("Contacts: ");
        for(Contact contact: contacts){
            System.out.println("Name: "+contact.getName()+", Phone number: "+contact.getPhoneNumber());
        }
    }

    public void operations() throws InvalidPhoneNumberException{
        boolean flag = true;
        while(flag){
            System.out.println("Menu: ");
            System.out.println("Enter '1' for adding contact.");
            System.out.println("Enter '2' for deleting contact.");
            System.out.println("Enter '3' for searching contact.");
            System.out.println("Enter '4' for displaying all contacts.");
            System.out.println("Enter '5' for exiting the program.");
            String userChoice = scan.next();

            switch (userChoice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    deleteContact();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    displayContacts();
                    break;
                case "5":
                    flag=false;
                    System.out.println("Exiting the program");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public static void main(String[] args) {
        PhoneContactOrganizer phone1 = new PhoneContactOrganizer();
        try {
            phone1.operations();
        } 
        catch (InvalidPhoneNumberException e) {
            System.out.println(e);
        }
        scan.close();
    }
    
}
