import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayStreamExample {
    
    public static void main(String[] args) {
        
        String fileName = "TestImage.jpeg";

        try(
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ){

            byte[] buffer = new byte[1024];
            int bytesRead;

            while((bytesRead = fileInputStream.read(buffer))!=-1){
                byteArrayOutputStream.write(buffer,0,bytesRead);
            }

            byte[] imageArray = byteArrayOutputStream.toByteArray();

            try (
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageArray);
                FileOutputStream fileOutputStream = new FileOutputStream("TestImageCopy.jpeg");
            ){
                byte[] buffer2 = new byte[1024];
                int bytesRead2;
                while((bytesRead2= byteArrayInputStream.read(buffer2)) != -1){
                    fileOutputStream.write(buffer2,0,bytesRead2);
                }
                System.out.println("Image copied successfully.");

            } 
            catch (IOException e) {
                System.out.println(e);
            }
        } 
        catch (IOException e) {
            System.out.println(e);
        }

    }
}
