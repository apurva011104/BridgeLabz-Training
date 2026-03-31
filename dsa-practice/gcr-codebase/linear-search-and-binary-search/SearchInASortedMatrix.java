public class SearchInASortedMatrix {

    public static boolean searchMatrix(int[][] matrix, int target){

        int rows = matrix.length, cols= matrix[0].length;

        int startRow = 0,  endRow = rows-1;

        while(startRow<=endRow){
            int midRow = startRow + (endRow - startRow)/2;
            if(target>=matrix[midRow][0] && target<=matrix[midRow][cols-1]){
                int startCol = 0, endCol = cols-1;
                while(startCol<=endCol){
                    int midCol = startCol + (endCol - startCol)/2;
                    if(matrix[midRow][midCol]==target){
                        return true;
                    }
                    if(matrix[midRow][midCol]>target){
                        endCol=midCol-1;
                    }
                    else{
                        startCol = midCol+1;
                    }
                }
                return false;
            }
            else if(matrix[midRow][0]>target){
                endRow = midRow - 1;
            }
            else{
                startRow = midRow + 1;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60},{67,74,79,86}};
        int target = 30;
        System.out.println("Do target element exists in 2D matrix? "+searchMatrix(matrix, target));
    }
}
