public class TabHistory {
    
    private VisitedLink headLink;
    private VisitedLink currentLink;

    private static boolean isURLValid(String url){
        final String urlRegex = "^(https?://)?(www\\.)?[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?(/\\S*)?$";
        return url.matches(urlRegex);
    }

    public void visitNewPage(String url, String websiteNameString){
        if(!isURLValid(url)){
            System.out.println("Error 404. Cannot visit site.");
            return;
        }
        VisitedLink link = new VisitedLink(url, websiteNameString);
        if(headLink == null){
            headLink = link;
            currentLink = link;
        }
        else{
            currentLink.setNext(null);
            link.setPrevious(currentLink);
            currentLink.setNext(link);
            currentLink = link;
        }
        displayCurrentLinkInformation();
    }

    public void goToNextPage(){
        if(currentLink== null || currentLink.getNext()==null){
            System.out.println("No next page available");
            return;
        }
        currentLink = currentLink.getNext();
        System.out.print("Navigated to next page successfully. ");
        displayCurrentLinkInformation();
    }

    public void goToPreviousPage(){
        if(currentLink== null || currentLink.getPrevious()==null){
            System.out.println("No previous page available");
            return;
        }
        currentLink = currentLink.getPrevious();
        System.out.println("Navigated to previous page successfully.");
        displayCurrentLinkInformation();
    }


    public void displayCurrentLinkInformation(){
        if(currentLink==null){
            System.out.println("No page to display");
            return;
        }
        System.out.printf("Current link url & website name: [%s , %s]%n",currentLink.getUrl(),currentLink.getWebsiteName());
    }
    
}
