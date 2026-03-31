import java.util.Scanner;
import java.util.Stack;

public class Browser {
    
    private static final Scanner SCAN = new Scanner(System.in);
    private final Stack<Tab> closedTabs;
    private Tab currentTab;

    public Browser() {
        this.closedTabs= new Stack<>();
        this.currentTab = null;
    }

    /*------------------------TAB OPERATIONS----------------------*/
    public Tab openNewTab(){
        Tab tab = new Tab();
        if(currentTab!=null){
            currentTab.updateIsOpen(false);
        }
        currentTab = tab;
        System.out.println("Opened new tab successfully");
        return tab;
    }
    
    public void closeCurrentTab(){
        if(currentTab == null){
            System.out.println("No opened tab to close");
            return;
        }
        closedTabs.push(currentTab);
        currentTab.updateIsOpen(false);
        currentTab = null;
        System.out.println("Tab closed successfully");
    }

    public void restoreClosedTab() {
        if (closedTabs.isEmpty()) {
            System.out.println("No closed tabs to restore");
            return;
        }
        Tab tab = currentTab;
        currentTab = closedTabs.pop();
        if(tab!=null){
            closedTabs.push(tab);
        }
        System.out.println("Closed tab restored");
        currentTab.getTabHistory().displayCurrentLinkInformation();
    }

    /*-------------------NAVIGATE OPERATIONS------------------*/
    public void visitNewPage(){
        if(currentTab==null){
            System.out.println("Open a new tab first or restore a close tab if there are any");
            return;
        }
        System.out.print("Enter url: ");
        String url= SCAN.nextLine();
        System.out.print("Enter website name: ");
        String websiteName = SCAN.nextLine();
        currentTab.getTabHistory().visitNewPage(url, websiteName);
    }

    public void goToPreviousPage(){
        if(currentTab==null){
            System.out.println("No active tab");
            return;
        }
        currentTab.getTabHistory().goToPreviousPage();
    }

    public void goToNextPage(){
        if(currentTab==null){
            System.out.println("No active tab");
            return;
        }
        currentTab.getTabHistory().goToNextPage();
    }

    public void showCurrentPage(){
        if(currentTab==null){
            System.out.println("No active tab");
            return;
        }
        currentTab.getTabHistory().displayCurrentLinkInformation();
    }

}
