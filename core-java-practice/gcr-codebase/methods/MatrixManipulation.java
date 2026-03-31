import java.util.Scanner;

public class MatrixManipulation {

    //Generating value of a matrix cell
    public static int generateElement(){
        return (int)(Math.random()*100);
    }

    //Creating a matrix
    public static int[][] createMatrix(int row, int column){
        int [][]matrix = new int[row][column];
        for(int i=0; i<row ; i++){
            for(int j=0 ; j<column ; j++){
                matrix[i][j]=generateElement();
            }
        }
        return matrix;
    }

    //Displaying matrix
    public static void displayMatrix(int [][]matrix){
        for(int i=0; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    //Matrix addition
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2){
        int[][] addedMatrix = new int[matrix1.length][matrix1[0].length];
        for(int i=0; i<matrix1.length ; i++){
            for(int j=0 ; j<matrix1[0].length; j++){
                addedMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return addedMatrix;
    }

    //Matrix subtraction
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2){
        int[][] matrixDifference = new int[matrix1.length][matrix1[0].length];
        for(int i=0; i<matrix1.length ; i++){
            for(int j=0 ; j<matrix1[0].length; j++){
                matrixDifference[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return matrixDifference;
    }

    //Matrix multiplication
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2){
        int [][]productMatrix = new int[matrix1.length][matrix2[0].length];
        for(int i=0 ; i<matrix1.length ; i++){
            for(int k=0 ; k<matrix2[0].length ; k++){
                for(int j=0 ; j<matrix1[0].length ; j++){
                    productMatrix[i][k] += ( matrix1[i][j] * matrix2[j][k] );
                }
            }
        }
        return productMatrix;
    }

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);

        System.out.print("Enter number of rows of matrix A: ");
        int row1=scan.nextInt();
        while(row1<=0){
            System.out.print("Number of rows must be greater than 0! Enter rows again: ");
            row1=scan.nextInt();
        }
        System.out.print("Enter number of columns of matrix A: ");
        int column1=scan.nextInt();
        while(column1<=0){
            System.out.print("Number of columns must be greater than 0! Enter columns again: ");
            column1=scan.nextInt();
        }
        System.out.print("Enter number of rows of matrix B: ");
        int row2=scan.nextInt();
        while(row2<=0){
            System.out.print("Number of rows must be greater than 0! Enter rows again: ");
            row2=scan.nextInt();
        }
        System.out.print("Enter number of columns of matrix B: ");
        int column2=scan.nextInt();
        while(column2<=0){
            System.out.print("Number of columns must be greater than 0! Enter columns again: ");
            column2=scan.nextInt();
        }

        int [][]matrixA = createMatrix(row1, column1);
        int [][]matrixB = createMatrix(row2, column2);

        //Displaying matrix A and matrix B
        System.out.println("Matrix A: ");
        displayMatrix(matrixA);
        System.out.println("Matrix B: ");
        displayMatrix(matrixB);

        //Matrix addition
        if(row1==row2 && column1==column2){
            int[][] sumMatrix = addMatrices(matrixA, matrixB);
            System.out.println("Resultant matrix after performing A+B: ");
            displayMatrix(sumMatrix);
        }
        else{
            System.out.println("Sum of matrices is not possible");
        }

        //Matrix subtraction
        if(row1==row2 && column1==column2){
            int[][] differenceMatrix = subtractMatrices(matrixA, matrixB);
            System.out.println("Resultant matrix after performing A-B: ");
            displayMatrix(differenceMatrix);
        }
        else{
            System.out.println("Subtraction of matrices is not possible");
        }

        //Matrix multipliactaion
        if(row2==column1){
            int[][] productAB = multiplyMatrices(matrixA, matrixB);
            System.out.println("Resultant matrix after performing AxB: ");
            displayMatrix(productAB);
        }
        else{
            System.out.println("Matrix A x Matrix B does not exists");
        }
        if(row1==column2){
            int[][] productAB = multiplyMatrices(matrixB, matrixA);
            System.out.println("Resultant matrix after performing BxA: ");
            displayMatrix(productAB);
        }
        else{
            System.out.println("Matrix B x Matrix A does not exists");
        }
    }
}
