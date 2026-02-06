public class PasswordStrengthValidator {
    
    public static void main(String[] args) {
        String password1 = "ThisIsAValidPassword123@";
        String password2 = "thisIsAnInvalidPassword";

        boolean isValid1 = SecurityUtils.validatePasswordStrength(password1);
        boolean isValid2 = SecurityUtils.validatePasswordStrength(password2);

        System.out.println("Is password '"+password1+"' valid?: "+isValid1);
        System.out.println("Is password '"+password2+"' valid?: "+isValid2);

    }
}

interface SecurityUtils{
    static boolean validatePasswordStrength(String password){
        if(password==null){
            throw new IllegalArgumentException("Password cannot be null");
        }
        if(password.contains(" ")){
            throw new IllegalArgumentException("Psssword cannot contain spaces");
        }

        if(password.length()<8){
            return false;
        }
        
        boolean containsUppercaseLetter = false;
        boolean containsLowercaseLetter = false;
        boolean containsDigit = false;
        boolean containsSymbol = false;

        for(char ch: password.toCharArray()){
            if(Character.isDigit(ch)){
                containsDigit = true;
            }
            else if(ch>='a' && ch<='z'){
                containsLowercaseLetter = true;
            }
            else if(ch>='A' & ch<='Z'){
                containsUppercaseLetter = true;
            }
            else if (!Character.isLetterOrDigit(ch) && ch!=' '){
                containsSymbol = true;
            }
        }

        return containsUppercaseLetter && containsLowercaseLetter && containsDigit && containsSymbol;
    }
}
