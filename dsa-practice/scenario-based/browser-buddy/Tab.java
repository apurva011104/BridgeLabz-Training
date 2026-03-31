public class Tab {
    
    private final TabHistory tabHistory;
    public boolean isOpen;

    public Tab() {
        this.tabHistory = new TabHistory();
        this.isOpen = true;
    }

    public boolean checkIfOpen() {
        return isOpen;
    }

    public void updateIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public TabHistory getTabHistory() {
        return tabHistory;
    }

}
