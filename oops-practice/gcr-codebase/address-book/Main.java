public class Main {

    public static void displayInfo(Contact contact){
        System.out.println("Contact details: ");
        System.out.println("Name: "+contact.getFirstName()+" "+contact.getLastName());
        System.out.println("Address: "+contact.getAddress());
        System.out.println("City: "+contact.getCity());
        System.out.println("ZIP Code: "+contact.getZip());
        System.out.println("Phone Number: "+contact.getPhoneNumber());
        System.out.println("Email ID: "+contact.getEmail());
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program.");

        try {
            Contact contact = new Contact("Apurva","Gupta","XYZ Lane","XYZ city","XYZ state","123456","1234567890","apurva@google.com");
            displayInfo(contact);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
