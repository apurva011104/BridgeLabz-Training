public class ReverseString {
    public static void main(String[] args) {
        StringBuilder string = new StringBuilder();
        string.append("vandalism");
        System.out.println("String before reverse: "+string);
        string.reverse();
        System.out.println("String after reverse: "+string);
    }
}
