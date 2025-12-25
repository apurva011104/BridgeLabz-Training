import java.util.Scanner;

public class ShortestTallestAndMeanHeight {

    public static double getHeight(){
        double height=0;
        while(height<150 || height>250){
            height=0;
            for(int i=0;i<3;i++){
                height=(height*10)+(Math.random()*9);
            }
        }
        return height;
    }

    public static void displayHeights(double []heights){
        System.out.print("[");
        for(int i=0;i<heights.length-1;i++){
            System.out.printf("%.3f cms, ",heights[i]);
        }
        System.out.printf("%.3f cms",heights[heights.length-1]);
        System.out.println("]");
    }

    public static double sumOfHeights(double []heights){
        double sum=0;
        for(double height: heights){
            sum+=height;
        }
        return sum;
    }

    public static double meanHeight(double []heights){
        double sum = sumOfHeights(heights);
        double mean = sum / heights.length;
        return mean;
    }

    public static double shortest(double []heights){
        double minimum = heights[0];
        for(double height: heights){
            minimum = Math.min( minimum, height);
        }
        return minimum;
    }

    public static double tallest(double []heights){
        double maximum = heights[0];
        for(double height: heights){
            maximum = Math.max( maximum, height );
        }
        return maximum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double []playersHeight=new double[11];
        for(int i=0;i<11;i++){
            playersHeight[i]=getHeight();
        }
        System.out.print("PLayer's height: ");
        displayHeights(playersHeight);
        System.out.printf("Shortest: %.3f cms\n",shortest(playersHeight));
        System.out.printf("Tallest: %.3f cms\n",tallest(playersHeight));
        System.out.printf("Mean height: %.3f cms\n", meanHeight(playersHeight));
    }
}
