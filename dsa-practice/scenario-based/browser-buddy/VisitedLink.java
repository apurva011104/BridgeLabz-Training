public class VisitedLink {

    private final String url;
    private final String websiteName;
    private VisitedLink next;
    private VisitedLink previous;

    public VisitedLink(String url, String websiteName) {
        this.url = url;
        this.websiteName = websiteName;
    }

    public String getUrl() {
        return url;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public VisitedLink getNext() {
        return next;
    }

    public void setNext(VisitedLink next) {
        this.next = next;
    }

    public VisitedLink getPrevious() {
        return previous;
    }

    public void setPrevious(VisitedLink previous) {
        this.previous = previous;
    }

    
}
