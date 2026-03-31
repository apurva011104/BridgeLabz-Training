public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String text = null;
        try {
            int len = text.length();    
        } 
        catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}
