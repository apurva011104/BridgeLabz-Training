import java.util.HashSet;

public class RemoveDuplicatesFromString {
    
    public static void removeDuplicates(StringBuilder string){
        HashSet<Character> unique = new HashSet<>();
        int index = 0;
        while(index<string.length()){
            if(string.charAt(index)==' '){
                index++;
                continue;
            }
            if(unique.contains(string.charAt(index))){
                string.deleteCharAt(index);
            }
            else{
                unique.add(string.charAt(index));
                index++;
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder string = new StringBuilder();
        string.append("removing duplicates from string");
        System.out.println("String before removing duplicates: "+string);
        removeDuplicates(string);
        System.out.println("String after removing duplicates: "+string);
    }
}
