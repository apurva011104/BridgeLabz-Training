
import java.util.Scanner;

public class BrowserBuddyMain {

    private static final Scanner SCAN = new Scanner(System.in);

    public static void userMenu(Browser browser){
        boolean flag = true;
        while(flag){
            System.out.println("Menu: ");
            System.out.println("Enter '1' to open new tab.");
            System.out.println("Enter '2' to close current tab.");
            System.out.println("Enter '3' to restore previously closed tab.");
            System.out.println("Enter '4' to visit new page.");
            System.out.println("Enter '5' to visit previous page.");
            System.out.println("Enter '6' to visit next page.");
            System.out.println("Enter '7' to show current page.");
            System.out.println("Enter '8' to exit the browser.");
            System.out.print("Enter your choice: ");
            String userChoice = SCAN.nextLine();

            switch(userChoice){
                case "1":
                    browser.openNewTab();
                    break;
                case "2":
                    browser.closeCurrentTab();
                    break;
                case "3":
                    browser.restoreClosedTab();
                    break;
                case "4":
                    browser.visitNewPage();
                    break;
                case "5":
                    browser.goToPreviousPage();
                    break;
                case "6":
                    browser.goToNextPage();
                    break;
                case"7":
                    browser.showCurrentPage();
                    break;
                case "8":
                    System.out.println("Exiting the browser");
                    flag=false;
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }


        }
    }
    
    public static void main(String[] args) {
        Browser browser = new Browser();
        userMenu(browser);
    }
}
