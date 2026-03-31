public class BubbleSortMergeSortAndQuickSortComparison {

    //Method to fill arrays with random non-negative integers
    public static void fillArray(int[] array1, int[] array2, int[] array3){
        for(int i=0; i<array1.length ; i++){
            array3[i] = array2[i] = array1[i] = (int)(Math.random()*Integer.MAX_VALUE);
        }
    }

    /*---------------------------SORTING ALGORITHMS------------------------------*/

    //Bubble Sort 
    public static void bubbleSort(int[] array){
        for(int i=0; i<array.length; i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }

    //Merge Sort
    public static void mergeSort(int[] array, int start, int end){
        if(start>=end){                 //Base Case: Start index becomes greater than or equal to end index
            return;
        }
        int mid = start + ((end-start)/2);
        //Dividing array into two parts until no more partition possible
        mergeSort(array, start, mid);            
        mergeSort(array, mid+1, end);
        //Merging after dividing array
        merge(array, start, end);
        
    }

    //Method to merge the divided parts in a sorted manner
    private static void merge(int[] array, int start, int end){
        int mid = start + ((end-start)/2);
        int length1 = mid - start + 1;
        int length2 = end - mid;
        int[] array1 = new int[length1];      //Will store the elements of first partition in the range
        int[] array2 = new int[length2];      //Will store the elements of second partition in the range
        for(int i=0; i<length1 ;i++){
            array1[i]=array[ i+start];
        }
        for(int i=0; i<length2 ;i++){
            array2[i]=array[i+mid+1];
        }

        int i=0, j=0;
        int k=start;
        //Merging in a sorted manner
        while(i<length1 || j<length2){
            if(i==length1){
                array[k]=array2[j];
                j++;
            }
            else if(j==length2){
                array[k]=array1[i];
                i++;
            }
            else{
                if(array1[i]<array2[j]){
                    array[k]=array1[i];
                    i++;
                }
                else{
                    array[k]=array2[j];
                    j++;
                }
            }
            k++;
        }
    }

    //Quick sort
    public static void quickSort(int[] array, int low, int high){
        if(low>=high){
            return;
        }
        int pivot = partition(array, low, high);

        quickSort(array, low, pivot-1);
        quickSort(array, pivot+1, high);

    }

    public static int partition(int[] array, int low, int high){
        int pivot = array[high];
        int idx = low - 1;

        for(int j=low ; j<=high ; j++){
            if(array[j]<pivot){
                idx++;
                swap(array,idx,j);
            }
        }
        swap(array,idx+1,high);
        return idx+1;
    }
    
    public static void swap( int[] array , int i, int j ){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /*--------------------------------------------------------------*/

    //Method to perform analysis
    public static long[] analyze(int[] bubbleSortArray, int[] mergeSortArray, int[] quickSortArray){
        long[] timeTaken = new long[3];

        long bubbleSortStartTime = System.nanoTime();
        bubbleSort(bubbleSortArray);
        long bubbleSortEndTime = System.nanoTime();
        timeTaken[0] = bubbleSortEndTime - bubbleSortStartTime;

        long mergeSortStartTime = System.nanoTime();
        mergeSort(mergeSortArray, 0 , mergeSortArray.length-1);
        long mergeSortEndTime = System.nanoTime();
        timeTaken[1] = mergeSortEndTime - mergeSortStartTime;

        long quickSortStartTime = System.nanoTime();
        quickSort(quickSortArray, 0, quickSortArray.length-1);
        long quickSortEndTime = System.nanoTime();
        timeTaken[2] =  quickSortEndTime - quickSortStartTime;

        return timeTaken;
    }

    public static void main(String[] args) {
        
        int[] bubbleSortArray1 = new int[1000];
        int[] mergeSortArray1 = new int[1000];
        int[] quickSortArray1 = new int[1000];

        int[] bubbleSortArray2 = new int[10000];
        int[] mergeSortArray2 = new int[10000];
        int[] quickSortArray2 = new int[10000];

        int[] bubbleSortArray3 = new int[1000000];
        int[] mergeSortArray3 = new int[1000000];
        int[] quickSortArray3 = new int[1000000];

        fillArray(bubbleSortArray1, mergeSortArray1, quickSortArray1);
        fillArray(bubbleSortArray2, mergeSortArray2, quickSortArray2);
        fillArray(bubbleSortArray3, mergeSortArray3, quickSortArray3);

        
        //Algorithm analysis
        System.out.println("Analysis for array whose dataset size is 1000");
        long[] analysis1 = analyze(bubbleSortArray1, mergeSortArray1, quickSortArray1);
        System.out.println("Time taken by bubble sort algorithm: "+analysis1[0]+" nanoseconds");
        System.out.println("Time taken by merge sort algorithm: "+analysis1[1]+" nanoseconds");
        System.out.println("Time taken by quick sort algorithm: "+analysis1[2]+" nanoseconds");
        System.out.println();
        
        System.out.println("Analysis for array whose dataset size is 10000");
        long[] analysis2 = analyze(bubbleSortArray2, mergeSortArray2, quickSortArray2);
        System.out.println("Time taken by bubble sort algorithm: "+analysis2[0]+" nanoseconds");
        System.out.println("Time taken by merge sort algorithm: "+analysis2[1]+" nanoseconds");
        System.out.println("Time taken by quick sort algorithm: "+analysis2[2]+" nanoseconds");
        System.out.println();

        System.out.println("Analysis for array whose dataset size is 1000000");
        long[] analysis3 = analyze(bubbleSortArray3, mergeSortArray3, quickSortArray3);
        System.out.println("Time taken by bubble sort algorithm: "+analysis3[0]+" nanoseconds");
        System.out.println("Time taken by merge sort algorithm: "+analysis3[1]+" nanoseconds");
        System.out.println("Time taken by quick sort algorithm: "+analysis3[2]+" nanoseconds");
        System.out.println();

    }
}
