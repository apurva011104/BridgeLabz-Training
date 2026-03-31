
import java.util.Scanner;

public class UserInterface {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Goods Transport details");
        String input = scanner.nextLine();

        Utility utility = new Utility();

        GoodsTransport transport = utility.parseDetails(input);
        if(transport==null){
            return;
        }

        String objectType = utility.findObjectType(transport);

        utility.displayTransportDetails(transport);
    }
}
