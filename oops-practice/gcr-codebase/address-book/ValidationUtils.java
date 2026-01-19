public final class ValidationUtils {

    private ValidationUtils(){}

    public static boolean validatePhoneNumber(String phoneNumber){
        if(phoneNumber.length()!=10){
            return false;
        }
        for(char digit: phoneNumber.toCharArray()){
            if(!Character.isDigit(digit)){
                return false;
            }
        }
        return true;
    }

    public static boolean validateEmail(String email){
        boolean atTheRateOccurrence = false;
        final String SYMBOLS = "_.+-@";

        for(char ch: email.toCharArray()){
            if(ch=='@'){
                if(atTheRateOccurrence){
                    return false;
                }
                atTheRateOccurrence=true;
            }
            if(!Character.isAlphabetic(ch) && !Character.isDigit(ch) && !SYMBOLS.contains(ch+"")){
                return false;
            }
        }

        return atTheRateOccurrence && email.indexOf('@') != 0 && email.indexOf('@') != email.length() - 1;

    }

    public static boolean validateZIP(String zip){
        if(zip==null || zip.length()!=6){
            return false;
        }
        for(char ch: zip.toCharArray()){
            if(!Character.isDigit(ch)){
                return false;
            }
        }
        return true;
    }
}

