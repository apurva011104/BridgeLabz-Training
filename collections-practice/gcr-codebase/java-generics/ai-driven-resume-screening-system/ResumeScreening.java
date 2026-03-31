import java.util.List;

public class ResumeScreening {

    public static void displayShortlisted(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            boolean isShortListed = ResumeManager.isShortListed(resume);
            System.out.printf("Candidate: %s | Role: %s | Shortlisted : %s%n",resume.getCandidateName(),resume.getJobRole().getRoleName(),(isShortListed?"Yes":"No"));
        }
    }
}
