package junit;

public class PasswordValidator {
    
    public static boolean validatePassword(String password){
        if(password==null){
            throw new IllegalArgumentException("Password cannot be null");
        }
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
