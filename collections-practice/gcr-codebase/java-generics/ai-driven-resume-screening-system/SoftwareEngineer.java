import java.util.Arrays;
import java.util.List;

public class SoftwareEngineer extends JobRole {

    public SoftwareEngineer() {
        super(Arrays.asList("Java","Data Structures and Algorithms","Object Oriented Programming","Database Management System","JUnit","Agile Framework"),
        "Software Engineer",6);
    }

    @Override
    public boolean evaluateSkills(List<String> candidateSkills){
        for(String requiredSkill: getSkillSet()){
            boolean doesCandidateHave = false;
            for(String candidateSkill: candidateSkills){
                if(requiredSkill.equalsIgnoreCase(candidateSkill)){
                    doesCandidateHave = true;
                    break;
                }
            }
            if(!doesCandidateHave){
                return false;
            }
        }
        return true;
    }

}