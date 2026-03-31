import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static List<CreatorStats> engagementBoard = new ArrayList<>();

    public void registerCreator(CreatorStats record){
        if(record==null){
            throw new IllegalArgumentException("Record cannot be null");
        }
        engagementBoard.add(record);
        System.out.println("Creator registered successfully");
    }

    public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold){
        Map<String, Integer> weeksCount = new LinkedHashMap<>();
        for(CreatorStats record: records){
            double[] weeklyLikes = record.getWeeklyLikes();
            int count = 0;
            for(double likes: weeklyLikes){
                if(likes>=likeThreshold){
                    count++;
                }
            }
            if(count>0){
                weeksCount.put(record.getCreatorName(), count);
            }
        } 
        return weeksCount;
    }

    public double calculateAverageLikes(){
        double totalLikes = 0;
        int totalWeeks = 0;
        for(CreatorStats record: engagementBoard){
            double[] weeklyLikes = record.getWeeklyLikes();
            for(double likes: weeklyLikes){
                totalLikes += likes;
                totalWeeks++;
            }
            
        } 
        if(totalWeeks == 0){
            return 0.0;
        }
        return totalLikes / totalWeeks;
    }

    public static void main(String[] args){
        final Scanner SCAN = new Scanner(System.in);

        Program program = new Program();

        boolean flag = true;

        while(flag){
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");
            String choice = SCAN.nextLine();
            
            switch (choice) {

                case "1":
                    System.out.println("Enter Creator Name:");
                    String creatorName = SCAN.nextLine().trim();
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    double[] weeklyLikes = new double[4];
                    for(int i=0 ; i<4; i++){
                        try {
                            String like = SCAN.nextLine().trim();
                            weeklyLikes[i] = Double.parseDouble(like);
                            if(weeklyLikes[i]<0){
                                System.out.println("Invalid likes count. Please try again.");
                                i--;
                            }
                        } 
                        catch (NumberFormatException e) {
                            System.out.println("Invalid likes count. Please enter again:");
                            i--;
                        }
                    }
                    CreatorStats record = new CreatorStats(creatorName, weeklyLikes);
                    program.registerCreator(record);
                    break;

                case "2":
                    System.out.println("Enter like threshold:");
                    boolean f = true;
                    double likeThreshold = 0;
                    while(f){
                        try {
                            likeThreshold = Double.parseDouble(SCAN.nextLine());
                            if(likeThreshold<0){
                                System.out.println("Invalid like threshold value. Please enter again:");
                                continue;
                            }
                            f = false;

                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid like threshold value. Please enter again:");
                        }
                    }
                    Map<String, Integer> weeksCount = program.getTopPostCounts(engagementBoard, likeThreshold);
                    if(weeksCount.isEmpty()){
                        System.out.println("No top-performing posts this week");
                    }
                    else{
                        for(Map.Entry<String, Integer> entry: weeksCount.entrySet()){
                            System.out.println(entry.getKey()+" - "+entry.getValue());
                        }
                    }
                    break;

                case "3":
                    double averageWeeklyLikes = program.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: "+averageWeeklyLikes);
                    break;
                case "4":
                    flag = false;
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
