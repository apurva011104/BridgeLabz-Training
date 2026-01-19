public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program.");

        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.addContact();
        try {
            addressBookMain.updateContact();
        } 
        catch (InvalidContactException e) {
            System.out.println(e);
        }
        
    }
}
