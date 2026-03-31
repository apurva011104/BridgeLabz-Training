import java.util.Arrays;
import java.util.HashSet;

public class GenerateOTP {

    public static int generateOTP(){
        int otp=0;
        for(int i=1;i<=6;i++){
            otp=(otp*10)+(int)(Math.random()*9);
        }
        return otp;
    }

    public static int[] generateOTPArray(){
        int[] otpArray = new int[10];
        HashSet<Integer> uniqueOTPs=new HashSet<>();
        for(int i=0 ; i<10 ;i++){
            int otp = generateOTP();
            while(uniqueOTPs.contains(otp)){
                otp=generateOTP();
            }
            otpArray[i]=otp;
            uniqueOTPs.add(otp);
        }
        return otpArray;
    }

    public static void main(String[] args) {
        int[] otpArray = generateOTPArray();
        System.out.println("OTPs: "+Arrays.toString(otpArray));
    }
}
