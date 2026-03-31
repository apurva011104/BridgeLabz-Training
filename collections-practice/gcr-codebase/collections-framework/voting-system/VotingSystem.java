public class VotingSystem {
    public static void main(String[] args) {
        Candidate candidate1 = new Candidate("1278", "A");
        Candidate candidate2 = new Candidate("6855", "B");
        Candidate candidate3 = new Candidate("7865", "C");

        VotingManager votingManager = new VotingManager();

        votingManager.castVote(candidate3);
        votingManager.castVote(candidate2);
        votingManager.castVote(candidate3);
        votingManager.castVote(candidate3);
        votingManager.castVote(candidate3);
        votingManager.castVote(candidate1);
        votingManager.castVote(candidate2);
        votingManager.castVote(candidate3);
        votingManager.castVote(candidate1);

        votingManager.displaySortedResults();
        System.out.println();
        votingManager.displayVotingOrder();
        System.out.println();

        votingManager.displayWinner();
    }
}
