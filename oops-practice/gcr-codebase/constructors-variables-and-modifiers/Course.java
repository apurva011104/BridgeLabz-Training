public class Course {
    
    private String courseName;          //Instance variable
    private int duration;           //Instance variable
    private double fee;         //Instance variable
    private static String instituteName = "GLA University";       //Class variable

    //Getters and setters
    public Course(String courseName , int duration, double fee) {
        setCourseName(courseName);
        setDuration(duration);
        setFee(fee);
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    public void setFee(double fee){
        this.fee = fee;
    }

    public String getCourseName(){
        return courseName;
    }

    public int getDuration(){
        return duration;
    }

    public double getFee(){
        return fee;
    }

    public static String getInstituteName(){
        return instituteName;
    }

    //Class method to update institute name
    public static void updateInstitueName(String newInstituteName){
        instituteName = newInstituteName;
    }

    //Instance method to display course details
    public void displayCourseDetails(){
        System.out.println("----------------------------------------------------");
        System.out.println("Institute name: "+getInstituteName());
        System.out.println("Course Name: "+getCourseName());
        System.out.println("Duration: "+getDuration()+" months");
        System.out.printf("Fee: INR %.2f%n",getFee());
        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args) {
        Course course1  = new Course("Cyber Security",4,10000.00);
        course1.displayCourseDetails();
        Course course2 = new Course("Software Development",6,14000.00);
        course2.displayCourseDetails();
        updateInstitueName("GLA");
        course1.displayCourseDetails();
        course2.displayCourseDetails();
        Course course3 = new Course("Web Development", 5, 11000.00);
        course3.displayCourseDetails();
    }
}
