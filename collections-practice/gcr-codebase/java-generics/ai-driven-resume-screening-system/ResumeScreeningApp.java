
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResumeScreeningApp {
    
    public static void main(String[] args) {
        
        DataScientist dataScientist = new DataScientist();
        SoftwareEngineer softwareEngineer = new SoftwareEngineer();
        ProductManager productManager = new ProductManager();

        Resume<SoftwareEngineer> resume1 = new Resume<>("Ava", 8,new ArrayList<>(Arrays.asList("Java","C++","Data Structures and Algorithms","Object Oriented Programming","Web Development","Database Management System","JUnit","Agile Framework")), softwareEngineer);
        Resume<DataScientist> resume2 = new Resume<>("Candice", 10, new ArrayList<>(Arrays.asList("Python","Pandas","NumPy","SQL","Machine Learning","Power BI","Scikit-learn")), dataScientist);
        Resume<DataScientist> resume3 = new Resume<>("Jennifer", 10, new ArrayList<>(Arrays.asList("R","Pandas","NumPy","SQL","Power BI","Scikit-learn")), dataScientist);
        Resume<ProductManager> resume4 = new Resume<>("Ruby", 28, new ArrayList<>(Arrays.asList("Excel","Communication","Data Analysis","Leadership","Agile framework")) , productManager);

        ResumeManager.addCandidateSkill(resume3, "Machine Learning");
        ResumeManager.removeCandidateSkill(resume3, "Power BI");
        List<Resume<? extends JobRole>> resumes= Arrays.asList(resume1,resume2,resume3,resume4);

        ResumeScreening.displayShortlisted(resumes);
    }

}
