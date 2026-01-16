public class Main{

    public static void displayContactInformation(Contacts contact){
        System.out.printf("Contact name: %s %s%n",contact.getFirstName(),contact.getLastName());
        System.out.println("Address: "+contact.getAddress());
        System.out.println("City: "+contact.getCity());
        System.out.println("State: "+contact.getState());
        System.out.println("ZIP Code: "+contact.getZip());
        System.out.println("Phone Number: "+contact.getPhoneNumber());
        System.out.println("Email ID: "+contact.getEmail());
    }


    public static void main(String[] args){
        System.out.println("Start");
        try {
            Contacts contact1 = new Contacts("Apurva","Gupta","XYZ lane","Agra","UP","282001","8475284522","apurva@google.com");
            displayContactInformation(contact1);
        } 
        catch (Exception e) {
            System.out.println(e);
        }

    }
}