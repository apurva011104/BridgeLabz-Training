public class CountBinarySubstrings {
    
    public static int countBinarySubstrings(String s) {
        int count = 0;
        int previous = 0;
        int current = 1;

        for(int i=1 ; i<s.length() ; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                current++;
            }
            else{
                count += Math.min(previous,current);
                previous = current;
                current = 1;
            }
        }
        count += Math.min(previous,current);

        return count;
    }

    public static void main(String[] args) {
        String s = "00110011";
        int count = countBinarySubstrings(s);
        System.out.println("Number of binary substrings: "+count);
    }
}
