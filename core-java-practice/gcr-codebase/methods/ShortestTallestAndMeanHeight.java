import java.util.Scanner;

public class ShortestTallestAndMeanHeight {

    //generate height
    public static double getHeight(){
        double height=0;
        while(height<150 || height>250){            //Making sure that height will be in range [150-250] otherwise a new height will be generated
            height=0;
            for(int i=0;i<3;i++){
                height=(height*10)+(Math.random()*9);
            }
        }
        return height;
    }

    //display heights
    public static void displayHeights(double []heights){
        System.out.print("[");
        for(int i=0;i<heights.length-1;i++){
            System.out.printf("%.3f cms, ",heights[i]);
        }
        System.out.printf("%.3f cms",heights[heights.length-1]);
        System.out.println("]");
    }

    //sum of the heights
    public static double sumOfHeights(double []heights){
        double sum=0;
        for(double height: heights){
            sum+=height;
        }
        return sum;
    }

    //mean height
    public static double meanHeight(double []heights){
        double sum = sumOfHeights(heights);
        double mean = sum / heights.length;
        return mean;
    }

    //shortest height
    public static double shortest(double []heights){
        double minimum = heights[0];
        for(double height: heights){
            minimum = Math.min( minimum, height);           //Comparing heights and storing the larger height in minimum variable
        }
        return minimum;
    }

    //tallest height
    public static double tallest(double []heights){
        double maximum = heights[0];
        for(double height: heights){
            maximum = Math.max( maximum, height );          //Comparing heights and storing the larger height in maximum variable
        }
        return maximum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //storing heights in an array
        double []playersHeight=new double[11];
        for(int i=0;i<11;i++){
            playersHeight[i]=getHeight();
        }
        //displaying all heights, shortest height, tallest height and mean height. 
        System.out.print("PLayer's height: ");
        displayHeights(playersHeight);
        System.out.printf("Shortest: %.3f cms\n",shortest(playersHeight));
        System.out.printf("Tallest: %.3f cms\n",tallest(playersHeight));
        System.out.printf("Mean height: %.3f cms\n", meanHeight(playersHeight));
    }
}
