
import java.util.ArrayList;

public class SuppressUncheckedWarningsExample {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add("Numbers");
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
    }
}
