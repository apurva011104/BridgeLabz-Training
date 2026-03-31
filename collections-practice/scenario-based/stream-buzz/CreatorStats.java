import java.util.Arrays;

public class CreatorStats {
    
    private String creatorName;
    private double[] weeklyLikes;

    public CreatorStats(String creatorName, double[] weeklyLikes) {
        this.creatorName = creatorName;
        this.weeklyLikes = weeklyLikes;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public double[] getWeeklyLikes() {
        return weeklyLikes;
    }

    public void setWeeklyLikes(double[] weeklyLikes) {
        this.weeklyLikes = weeklyLikes;
    }

    @Override
    public String toString() {
        return String.format("[Creator: %s, Weekly Likes: %s]", creatorName, Arrays.toString(weeklyLikes));
    }
    
}
