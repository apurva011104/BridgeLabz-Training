public class romanToInteger {
    public int romanToInt(String s) {
        int num=0;
        while(num<s.length()/2){
            s=s.substring(0,num)+s.charAt(s.length()-1-num)+s.substring(num+1,s.length()-1-num)+s.charAt(num)+s.substring(s.length()-num);
            num++;
        }
        num=0;
        while(s.length()!=0){
            if(s.charAt(0)=='I')
                num++;
            else if(s.charAt(0)=='V' ||  s.charAt(0)=='X'){
                if(s.charAt(0)=='V')
                    num+=5;
                else
                    num+=10;
                if(s.length()>1 && s.charAt(1)=='I'){
                    num--;
                    s=s.substring(1);
                }
            }
            else if(s.charAt(0)=='L' || s.charAt(0)=='C'){
                if(s.charAt(0)=='L')
                    num+=50;
                else
                    num+=100;
                if(s.length()>1 && s.charAt(1)=='X'){
                    num-=10;
                    s=s.substring(1);
                }
            }
            else{
                if(s.charAt(0)=='D')
                    num+=500;
                else
                    num+=1000;
                if(s.length()>1 && s.charAt(1)=='C'){
                    num-=100;
                    s=s.substring(1);
                }
            }
            s=s.substring(1);
        }
        return num;
    }
    public static void main(String[] args) {
        romanToInteger obj = new romanToInteger();
        String romanNumeral = "MCMXCIV"; // Example Roman numeral
        int integerValue = obj.romanToInt(romanNumeral);
        System.out.println("The integer value of the Roman numeral " + romanNumeral + " is: " + integerValue);
    }
}
