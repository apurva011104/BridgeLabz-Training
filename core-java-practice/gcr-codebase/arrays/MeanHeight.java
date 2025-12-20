import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Taking height input
        double []playersHeight = new double[11];        //Initialized an array to store heights
        for(int i=0;i<11;i++){
            System.out.print("Enter the height of player "+(i+1)+"(in cms): ");
            double height=scan.nextDouble();
            //Checking if height is positive or not
            if(height<=0){
                System.out.println("Invalid height! Enter again.");
                i--;
                continue;
            }
            playersHeight[i]=height;
        }

        //Calculating average
        double totalHeight = 0.0;
        for(double height: playersHeight){
            totalHeight += height;
        }
        double meanHeight = totalHeight / 11;
        
        System.out.printf("Mean height of all the players is %.3f cms",meanHeight);

        scan.close();
    }
}
