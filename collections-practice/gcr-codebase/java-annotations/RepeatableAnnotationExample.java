import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class RepeatableAnnotationExample {
    
    @BugReport(description="Might throw ArrayIndexOutOfBoundsException")
    @BugReport(description="Might throw NullPointerException")
    public static int  fetchValueAtIndex(int[] array, int index){
        return array[index];
    }
    
    public static void main(String[] args) {
        try {
            Method method = RepeatableAnnotationExample.class.getDeclaredMethod("fetchValueAtIndex", int[].class, int.class);

            BugReport[] reports = method.getAnnotationsByType(BugReport.class);
            for(BugReport report: reports){
                System.out.println(report);
            }
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}


@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport{
    String description();
}
