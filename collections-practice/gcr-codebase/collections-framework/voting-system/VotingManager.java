import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VotingManager {
    
    private final HashMap<Candidate, Integer> ballot;

    public VotingManager() {
        this.ballot = new LinkedHashMap<>();
    }

    public void castVote(Candidate candidate){
        ballot.put(candidate, ballot.getOrDefault(candidate, 0)+1);
    }

    public void displayVotingOrder(){
        System.out.println("Voting order: ");
        for(Map.Entry<Candidate,Integer> entry: ballot.entrySet()){
            System.out.println("("+entry.getKey()+")"+": "+entry.getValue());
        }
    }

    public void displaySortedResults(){
        TreeMap<Candidate, Integer> sortedByName = new TreeMap<>((c1,c2)->c1.getName().compareTo(c2.getName()));
        sortedByName.putAll(ballot);
        System.out.println("Sorted results(by Candidate Name): ");
        for (Map.Entry<Candidate, Integer> entry : sortedByName.entrySet()) {
             System.out.println("("+entry.getKey()+")"+": "+entry.getValue());
        }
    }

    public void displayWinner(){
        List<Candidate> winner = new ArrayList<>();
        int maxVotes = 0;
        for(Map.Entry<Candidate, Integer> entry: ballot.entrySet()){
            if(maxVotes==entry.getValue()){
                winner.add(entry.getKey());
            }
            else if(maxVotes<entry.getValue()){
                maxVotes = entry.getValue();
                winner= new ArrayList<>();
                winner.add(entry.getKey());
            }
        }
        if(winner.size()>1){
            System.out.print("Tie in between "+winner.get(0).getName());
            for(int i=1; i< winner.size()-1;i++){
                System.out.print(", "+winner.get(i).getName());
            }
            System.out.println(" and "+winner.get(winner.size()-1).getName());
        }
        else if(winner.size()==1){
            System.out.println("Winner: "+winner.get(0).getName());
        }
        else{
            System.out.println("No winner");
        }
    }

}
