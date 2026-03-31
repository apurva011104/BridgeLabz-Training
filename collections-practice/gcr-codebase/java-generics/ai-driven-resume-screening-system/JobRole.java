import java.util.List;

public abstract class JobRole {
    
    private final List<String> skillSet;
    private final String roleName;
    private final int minimumExperienceInMonths;

    public JobRole(List<String> skillSet, String roleName, int minimumExperienceInMonths) {
        this.skillSet = skillSet;
        this.roleName = roleName;
        this.minimumExperienceInMonths = minimumExperienceInMonths;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getMinimumExperience() {
        return minimumExperienceInMonths;
    }
    
    public boolean evaluateSkills(List<String> candidateSkills){
        return matchSkills(candidateSkills);
    }

    protected boolean matchSkills(List<String> candidateSkills){
        for(String requiredSkill: skillSet){
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

    public List<String> getSkillSet() {
        return skillSet;
    }
}
