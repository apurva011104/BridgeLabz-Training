
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void addressBookMenu(AddressBook addressBook){

        System.out.println("Address Book "+ addressBook.getName()+" opened");
        AddressBookMain addressBookMain = new AddressBookMain(addressBook);

        boolean flag = true;

        while(flag){
            System.out.println("Enter '1' to add contacts.");
            System.out.println("Enter '2' to update contacts.");
            System.out.println("Enter '3' to delete a contact.");
            System.out.println("Enter '4' to return to address book system.");
            System.out.print("Enter your choice: ");
            String input = SCANNER.nextLine().trim();

            switch (input) {
                case "1":
                    addressBookMain.addMultipleContacts();
                    break;  
                case "2":
                    try {
                        addressBookMain.updateContact();
                    } catch (InvalidContactException e) {
                        System.out.println(e.getMessage());
                    }
                    break; 
                case "3":
                    try {
                        addressBookMain.deleteContact(); 
                    } catch (InvalidContactException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    flag = false;
                    System.out.println("Going back to address book system...");
                    break;
                default:
                    System.out.println("Invalid input");
            }

        }

    }

    public static void addressBookSystemMenu(){

        AddressBookSystemMain addressBookSystemMain = new AddressBookSystemMain();
        boolean flag = true;
        while(flag){
            System.out.println("Enter '1' to add new address book.");
            System.out.println("Enter '2' to open a address book.");
            System.out.println("Enter '3' to exit the program.");
            System.out.print("Enter your choice: ");
            String input = SCANNER.nextLine().trim();

            switch (input) {
                case "1":
                    addressBookSystemMain.addAddressBook();
                    break;
                case "2":
                    try {
                        AddressBook addressBook = addressBookSystemMain.getAddressBook();
                        addressBookMenu(addressBook);
                    } 
                    catch (InvalidAddressBookException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    flag = false;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program.");
        addressBookSystemMenu();
        
    }
}
