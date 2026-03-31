package junit;

import java.util.ArrayList;
import java.util.List;

public class UserRegistration {
    class User{
        String username;
        String email;
        String password;

        public User(String username, String email, String password) {
            this.username = username;
            this.email = email;
            this.password = password;
        }

    }

    List<User> users;

    public UserRegistration() {
        this.users = new ArrayList<>();
    }

    public void registerUser(String username, String email, String password){
        if(username==null || email==null  || password==null || !validateUsername(username) || !validateEmail(email) || !validatePassword(password)){
            throw new IllegalArgumentException("Invalid Username, email or password.");
        }

        User user = new User(username, email, password);
        users.add(user);
        System.out.println("Registered user successfully");
    }

    private static boolean validateUsername(String username){
        if(username.length()==0){
            return false;
        }
        for(char ch: username.toCharArray()){
            if(!Character.isLetterOrDigit(ch) && ch!='.' && ch!='_'){
                return false;
            }
        }
        return !(!Character.isLetterOrDigit(username.charAt(0)) || !Character.isLetterOrDigit(username.charAt(username.length()-1)));
    }

    private static boolean validateEmail(String email){
        if(email.length()==0){
            return false;
        }
        if(!email.contains("@")){
            return false;
        }
        for(char ch: email.toCharArray()){
            if(!Character.isLetterOrDigit(ch) && ch!='@'){
                return false;
            }
        }
        return !(email.endsWith("@") || email.startsWith("@"));

    }

    private static boolean validatePassword(String password){
        if(password.length()<8){
            return false;
        }
        boolean containsUppercase = false;
        boolean containsDigit = false;

        for(char ch: password.toCharArray()){
            if(ch>='A' && ch<='Z'){
                containsUppercase = true;
            }
            if(ch>='0' && ch<='9'){
                containsDigit = true;
            }
        }
        return containsUppercase && containsDigit;
    }
    
}
