import java.util.Scanner;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows=scan.nextInt();
        System.out.print("Enter number of columns: ");
        int columns=scan.nextInt();

        int twoDimensionalArray[][]=new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print("Enter element of row "+i+" and column "+j+": ");
                twoDimensionalArray[i][j]=scan.nextInt();
            }
        }

        int oneDimensionalArray[] = new int[rows * columns];
        int index=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                oneDimensionalArray[index]=twoDimensionalArray[i][j];
                index++;
            }
        }
        
        System.out.println("Two Dimensional Array: ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(twoDimensionalArray[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("One Dimensional Array: ");
        for(int i: oneDimensionalArray){
            System.out.print(i+" ");
        }

        scan.close();
    }
}
