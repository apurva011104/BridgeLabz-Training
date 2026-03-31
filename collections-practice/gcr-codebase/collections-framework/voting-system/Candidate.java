public class Candidate {
    
    private final String  candidateID;
    private final String name;

    public Candidate(String candidateID, String name) {
        this.candidateID = candidateID;
        this.name = name;
    }

    public String getCandidateID() {
        return candidateID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Candidate ID: "+candidateID+", Candidate Name: "+name;
    }

}
