import java.util.List;

public class Resume <T extends JobRole>{
    
    private final String candidateName;
    private final int experienceInMonths;
    private final List<String> skills;
    private final T jobRole;

    public Resume(String candidateName, int experienceInMonths, List skills, T jobRole) {
        this.candidateName = candidateName;
        this.experienceInMonths = experienceInMonths;
        this.skills = skills;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceInMonths() {
        return experienceInMonths;
    }

    public List<String> getSkills() {
        return skills;
    }

    public T getJobRole() {
        return jobRole;
    }
    
    
}
