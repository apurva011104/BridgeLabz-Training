import java.util.Scanner;

public class MatrixManipulation2 {

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

    public static int[][] transpose(int[][] matrix){
        int[][] transpose = new int[matrix[1].length][matrix.length];
        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix[1].length ; j++){
                transpose[j][i]=matrix[i][j];
            }
        }
        return transpose;
    }

    //Determinant of 2x2 matrix
    public static int determinant22(int [][]matrix){
        return (matrix[0][0]*matrix[1][1])-(matrix[0][1]*matrix[1][0]);
    }

    //Determinant of 3x3 matrix
    public static int determinant33(int [][]matrix){
        int determinant=0; 
        for(int i=0;i<3;i++){ 
            int p1=1,p2=1; 
            for(int j=1;j<3;j++){ 
                p1*=matrix[j][(i+j)%3]; 
                p2*=matrix[j][(i-j+3)%3]; 
            } 
            determinant+=(matrix[0][i]*(p1-p2)); 
        }
        return determinant;
    }

    public static int[][] inverseMatrix22(int[][] matrix){
        int determinant=determinant22(matrix);
        int [][]inverse =new int[2][2];
        inverse[0][0]=matrix[1][1]/determinant;
        inverse[1][1]=matrix[0][0]/determinant;
        inverse[0][1]=(-1*matrix[1][0])/determinant;
        inverse[1][0]=(-1*matrix[0][1])/determinant;
        return inverse;
    }

    public static int[][] inverseMatrix33(int[][] matrix){
        int determinant = determinant33(matrix);
        int [][]inverse =new int[3][3];
        int [][]adjoint = new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                adjoint[i][j] = (matrix[(i+1)%3][(j+1)%3] * matrix[(i+2)%3][(j+2)%3]) - (matrix[(i+1)%3][(j-1+3)%3] * matrix[(i+2)%3][(j-2+3)%3]);
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                inverse[i][j]=adjoint[i][j]/determinant;
            }
        }
        return inverse;
    }
    public static void main(String[] args) {
        
        Scanner scan =new Scanner(System.in);

        System.out.print("Enter number of rows of matrix: ");
        int row=scan.nextInt();
        while(row<=0){
            System.out.print("Number of rows must be greater than 0! Enter rows again: ");
            row=scan.nextInt();
        }
        System.out.print("Enter number of columns of matrix ");
        int column=scan.nextInt();
        while(column<=0){
            System.out.print("Number of columns must be greater than 0! Enter columns again: ");
            column=scan.nextInt();
        }
        int [][]matrix =createMatrix(row, column);
        System.out.println("Matrix: ");
        displayMatrix(matrix);

        int[][] transpose = transpose(matrix);
        System.out.println("Transpose: ");
        displayMatrix(transpose);

        if(row==2 && column==2){
            int determinant = determinant22(matrix);
            System.out.println("Determinant: "+determinant);
            if(determinant==0){
                System.out.println("Inverse does not exists");
            }
            else{
                int[][] inverse= inverseMatrix22(matrix);
                System.out.println("Inverse: ");
                displayMatrix(inverse);
            }   
        }
        if(row==3 && column==3){
            int determinant = determinant33(matrix);
            System.out.println("Determinant: "+determinant);
            if(determinant==0){
                System.out.println("Inverse does not exists");
            }
            else{
                int[][] inverse= inverseMatrix33(matrix);
                System.out.println("Inverse: ");
                displayMatrix(inverse);
            }   
        }

    }
}
