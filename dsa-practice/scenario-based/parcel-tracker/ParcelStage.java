public class ParcelStage {
    
    private final String stageName;
    private ParcelStage nextStage;

    public ParcelStage(String stageName) {
        this.stageName = stageName;
    }

    public String getStageName() {
        return stageName;
    }

    public ParcelStage getNextStage() {
        return nextStage;
    }

    public void setNextStage(ParcelStage nextStage) {
        this.nextStage = nextStage;
    }

    
}
