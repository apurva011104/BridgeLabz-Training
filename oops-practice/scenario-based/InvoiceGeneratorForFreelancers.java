
import java.util.Scanner;

public class InvoiceGeneratorForFreelancers {

    static final String regex = "^([A-Za-z ]+) - (\\d+) INR$";


    public static String[] parseInvoice(String invoices) throws Exception{
        String []invoice = invoices.split(",");
        for(int i=0;i<invoice.length;i++){
            invoice[i] = invoice[i].trim();
            if(!invoice[i].matches(regex)){
                throw new Exception();
            }
        }
        return invoice;
    }

    public static String[][] splitTaskAndAmount(String []invoice){
        String [][]taskAndAmount = new String[invoice.length][2];
        for(int i=0; i<invoice.length;i++){
            taskAndAmount[i]=invoice[i].split("-");
            taskAndAmount[i][0]=taskAndAmount[i][0].trim();
            taskAndAmount[i][1]=taskAndAmount[i][1].trim();
        }
        return taskAndAmount;  
    }

    public static double getTotalAmount(String[] invoice){
        String [][]taskAndAmount = splitTaskAndAmount(invoice);
        double total =0;
        for(int i=0; i<taskAndAmount.length ;i++){
            String amountWithoutCurrency = taskAndAmount[i][1].substring(0,taskAndAmount[i][1].length()-4);
            int amount = Integer.parseInt(amountWithoutCurrency);
            total+=amount;
        }
        return total;
    }

    public static void displayInvoices(String []invoice){
        String [][]taskAndAmount = splitTaskAndAmount(invoice);

        System.out.println("Task\t\t\tAmount");
        
        for(int i=0;i<invoice.length;i++){
            System.out.println(taskAndAmount[i][0]+"\t\t\t"+taskAndAmount[i][1]);
        }
        
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter all the invoices in the format \"Task name - Amount INR\", seperated by a comma");
        String invoices= scan.nextLine().trim();
        try {
            String []invoice = parseInvoice(invoices);
            displayInvoices(invoice);
            System.out.printf("Total invoice amount: %.f INR%n",getTotalAmount(invoice));

        } 
        catch (Exception e) {
            System.out.println("Invalid invoice found among all the invoices");
            return;
        }
    }
}
