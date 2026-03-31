public class ValidParenthesisString {
    public static boolean checkValidString(String s) {
        int lp=0;
        int rp=0;
        for(char ch: s.toCharArray()){
            if(ch=='(') {
                lp++;
                rp++;
            }
            else if(ch==')') {
                lp--;
                rp--;
            }
            else{
                lp++;
                rp--;

            }
            if(lp<0){
                return false;
            }
            if(rp<0){
                rp=0;
            }
        }
        return rp==0;
    }

    public static void main(String[] args) {
        String s = "(*))";
        boolean isValid = checkValidString(s);
        System.out.println(isValid);
    }
}
