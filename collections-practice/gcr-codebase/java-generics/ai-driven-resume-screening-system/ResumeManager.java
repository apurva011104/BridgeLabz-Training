import java.util.List;

public class ResumeManager {
    
    private static boolean isSkillPresentInResume(Resume<? extends JobRole> resume, String skill){
        List<String> candiadteSkill = resume.getSkills();
        for(String s: candiadteSkill){
            if(s.equalsIgnoreCase(skill)){
                return true;
            }
        }
        return false;
    }


    public static void addCandidateSkill(Resume<? extends JobRole> resume, String skill){
        if(isSkillPresentInResume(resume, skill)){
            System.out.println("Skill already present in resume");
            return;
        }
        resume.getSkills().add(skill);
        System.out.println("Skill added in "+resume.getCandidateName()+"'s resume successfully");
    }

    public static void removeCandidateSkill(Resume<? extends JobRole> resume, String skill){
        if(!isSkillPresentInResume(resume, skill)){
            System.out.println("Skill not present in resume");
            return;
        }
        for(String s: resume.getSkills()){
            if(s.equalsIgnoreCase(skill)){
                skill = s;
                break;
            }
        }
        resume.getSkills().remove(skill);
        System.out.println("Skill removed from "+resume.getCandidateName()+"'s resume successfully");
    }

    public static boolean isShortListed(Resume<? extends JobRole> resume){
        boolean isShortlisted= resume.getJobRole().evaluateSkills(resume.getSkills());
        boolean enoughExperience = resume.getJobRole().getMinimumExperience()<=resume.getExperienceInMonths();
        return enoughExperience && isShortlisted;
    }
}
