import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class MaxLengthAnotationForFieldValidation {

    public static void main(String[] args) {
        User user = new User("itzAva");
        System.out.println(user);
    }
    
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength{
    int value();
}

class  User{

    @MaxLength(value=20)
    String username;

    public User(String username) {
        if(!validateUsername(username)){
            throw new IllegalArgumentException("Username exceeds the maximum length.");
        }
        this.username = username;
    }

    private boolean validateUsername(String username){
        try {
            Field field = User.class.getDeclaredField("username");
            field.setAccessible(true);
            MaxLength maxLength = field.getAnnotation(MaxLength.class);
            if(maxLength!=null){
                if(username.length()>maxLength.value()){
                    return false;
                }
            }
            return true;
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Username: "+username;
    }

    

}