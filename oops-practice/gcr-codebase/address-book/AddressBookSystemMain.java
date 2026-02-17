import java.util.List;
import java.util.Scanner;

public class AddressBookSystemMain {
    
    private static final Scanner SCANNER = new Scanner(System.in);
    private AddressBookSystem addressBookSystem;

    public AddressBookSystemMain() {
        this.addressBookSystem = new AddressBookSystem();
    }

    public void addAddressBook(){
        try {
            System.out.println("Enter name of the new address book: ");
            String name = SCANNER.nextLine().trim().replaceAll("\\s+", " ");
            addressBookSystem.addAddressBook(name);
        } 
        catch (NameAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public AddressBook getAddressBook() throws InvalidAddressBookException{
        System.out.print("Enter the name of address book: ");
        String name = SCANNER.nextLine().trim().replaceAll("\\s+", " ");
        AddressBook addressBook = addressBookSystem.searchAddressBook(name);
        if(addressBook==null){
            throw new InvalidAddressBookException("No such address book exists.");
        }
        return addressBook;
    }

    public void searchContactsAcrossCityOrState(){
        System.out.print("Enter the name of city or state: ");
        String keyword = SCANNER.nextLine().trim().replaceAll("\\s+", " ");
        List<Contact> searchResults = addressBookSystem.searchPersonsAcrossCityOrState(keyword);
        if(searchResults.isEmpty()){
            System.out.println("No contacts found");
            return;
        }
        System.out.println("Search results: ");
        for(Contact contact: searchResults){
            System.out.println(contact);
        }
    }
    
}
