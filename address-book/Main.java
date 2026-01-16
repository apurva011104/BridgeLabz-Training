public class Main{

    public static void main(String[] args){
        System.out.println("Start");
        AddressBookMain addressBook = new AddressBookMain();

        Contacts contact = addressBook.addContact();
        try {
            addressBook.displayContactInformation(contact);
            addressBook.updateContact(contact);
            addressBook.displayContactInformation(contact);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        

    }
}