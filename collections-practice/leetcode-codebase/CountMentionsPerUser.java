import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountMentionsPerUser {

    private void sortList(List<List<String>> events){
        Collections.sort(events, (e1, e2)-> {
            int c= Integer.compare(Integer.parseInt(e1.get(1)), Integer.parseInt(e2.get(1)));
            if(c==0){
                return e2.get(0).compareTo(e1.get(0));
            }
            return c;
        });
    }

    private void makeUsersOnline(int numberOfUsers, int[][] offlineStatus, int currentTimestamp){
        for(int id=0 ; id<numberOfUsers ; id++){
            if(offlineStatus[id][0] == 1 && offlineStatus[id][1]+60 <= currentTimestamp){
                offlineStatus[id][0] = 0;
                offlineStatus[id][1] = -1;
            }
        }
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        sortList(events);

        int[] numberOfMentions = new int[numberOfUsers];

        int[][] offlineStatus = new int[numberOfUsers][2];
        for(int i=0 ; i<numberOfUsers; i++){
            offlineStatus[i][0] = 0;
            offlineStatus[i][1] = -1;
        } 
        
        for(int i=0 ; i<events.size() ; i++){
            String eventType = events.get(i).get(0);
            int currentTimestamp = Integer.parseInt(events.get(i).get(1));
            String users = events.get(i).get(2);
            
            if(eventType.equals("OFFLINE")){
                int id = Integer.parseInt(users);
                offlineStatus[id][0] = 1;
                offlineStatus[id][1] = currentTimestamp;
            }
            else{
                makeUsersOnline(numberOfUsers, offlineStatus, currentTimestamp);
                if(users.equals("ALL")){
                    for(int id=0 ; id<numberOfUsers ; id++){
                        numberOfMentions[id]++;
                    }
                }
                else if(users.equals("HERE")){
                    for(int id=0 ; id<numberOfUsers ; id++){
                        if(offlineStatus[id][0]==0){
                            numberOfMentions[id]++;
                        }
                    }
                }
                else{
                    String[] userIDs = users.split(" ");
                    for(String userID: userIDs){
                        int id = Integer.parseInt(userID.substring(2,userID.length()));
                        numberOfMentions[id]++;
                    }
                }
            }
        }
        return numberOfMentions;
    }

    public static void main(String[] args) {
        CountMentionsPerUser countMentionsPerUser = new CountMentionsPerUser();
        int numberOfUsers = 2;

        List<List<String>> events = new ArrayList<>();
        events.add(Arrays.asList("MESSAGE","10","id1 id0"));
        events.add(Arrays.asList("OFFLINE","11","0"));
        events.add(Arrays.asList("MESSAGE","71","HERE"));

        int[] numberOfMentions = countMentionsPerUser.countMentions(numberOfUsers, events);

        System.out.println(Arrays.toString(numberOfMentions));
    }
    
}
