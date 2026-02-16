
import java.util.HashMap;
import java.util.Map;

public class AddressBookSystem {

    private final Map<String, AddressBook> addressBooks; 

    public AddressBookSystem() {
        this.addressBooks = new HashMap<>();
    }

    public void addAddressBook(String name) throws NameAlreadyExistsException{
        if(!isUniqueName(name)){
            throw new NameAlreadyExistsException("Address book name already exists.");
        }
        AddressBook book = new AddressBook(name);
        addressBooks.put(name, book);
        System.out.println("Address book "+name+" added successfully");
    }

    public AddressBook searchAddressBook(String name){
        for(String bookName: addressBooks.keySet()){
            if(bookName.equalsIgnoreCase(name)){
                return addressBooks.get(bookName);
            }
        }
        return null;
    }
    
    private boolean isUniqueName(String name){
        for(String bookName: addressBooks.keySet()){
            if(bookName.equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }
}
