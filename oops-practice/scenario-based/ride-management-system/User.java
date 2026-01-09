import java.util.HashSet;
import java.util.Set;

class User extends Person {

    private static  Set<String> allUserID = new HashSet<>();

    public User(String name, String phoneNumber) throws InvalidPhoneNumberException, PhoneNumberAlreadyExistsException{  
        super(generateID(),name,phoneNumber);
    }

    private static boolean isUniqueID(String id){
        return !allUserID.contains(id);
    }

    private static String generateID(){
        String userId ="USR";
        do {
            StringBuilder id = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                id.append((char) ('0' + (int)(Math.random() * 10)));
            }
            userId += id.toString();
        } 
        while (!isUniqueID(userId));

        allUserID.add(userId);
        return userId;
    }


}
