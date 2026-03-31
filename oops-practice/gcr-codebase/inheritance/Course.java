public class Course {

    String courseId;
    String courseName;
    int duration;

    public Course(String courseId, String courseName, int duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayInfo(){
        System.out.println("Course Id: "+courseId);
        System.out.println("Course Name: "+courseName);
        System.out.println("Course Duration: "+duration+" months");
    }
    
}

class OnlineCourse extends Course{

    String platform;
    boolean isRecorded;

    public OnlineCourse( String courseId, String courseName, int duration, String platform, boolean isRecorded) {
        super(courseId, courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Course available on platforms: "+platform);
        System.out.println("Is course recorded? "+(isRecorded?"Yes":"No"));
    }
    
}

class PaidOnlineCourse extends OnlineCourse{

    private double fee;
    private static double discount=10.0;

    public PaidOnlineCourse( String courseId, String courseName, int duration, String platform, boolean isRecorded, double fee){
        super(courseId, courseName, duration, platform, isRecorded);
        this.fee = fee;
    }

    //Getter and setter for fee
    public void setFee(double fee){
        this.fee = fee;
    }
    public double getFee(){
        return fee;
    }

    //Getter and setter for discount
    public void setDiscount(double discount){
        this.discount = discount;
    }
    public double getDiscount(){
        return discount;
    }

    public double calculateFeeAfterDiscount(){
        double discountedPrice = (fee * discount) / 100;
        return fee - discountedPrice;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.printf("Course fee: $%.2f%n",fee);
        System.out.printf("Discount: %.2f%%%n",discount);
        System.out.printf("Course fee after applying discount: $%.2f%n",calculateFeeAfterDiscount());
    }

}

//Main class for testing
class Main{
    public static void main(String[] args) {
        Course course1 = new Course("CO1247", "Java Programming", 3);

        OnlineCourse course2 = new OnlineCourse("OC0754","Python programming",2,"YouTube, Udemy",false);

        PaidOnlineCourse course3 = new PaidOnlineCourse("POC0019", "Web Development", 4, "Udemy, GeeksForGeeks, E-learn", true, 750.00);

        course1.displayInfo();
        System.out.println();
        course2.displayInfo();
        System.out.println();
        course3.displayInfo();
        
    }
}