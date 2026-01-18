public class StringConcatenationPerformance {

    public static void stringConcatenation(String string, int iterations){
        String concatenatedString = "";
        for(int i=0; i<iterations ; i++){
            concatenatedString += string;
        }
    }

    public static void stringBuilderConcatenation(String string, int iterations){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<iterations ; i++){
            stringBuilder.append(string);
        }
    }

    public static void stringBufferConcatenation(String string, int iterations){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0; i<iterations ; i++){
            stringBuffer.append(string);
        }
    }

    //Method to perform analysis
    public static void analyze(int iterations){
        String string= "hello";
    
        long stringBuilderStartTime = System.nanoTime();
        stringBuilderConcatenation(string, iterations);
        long stringBuilderEndTime = System.nanoTime();
        long timeTakenStringBuilder = stringBuilderEndTime - stringBuilderStartTime;
        System.out.println("Time taken by string builder to concatenate: "+timeTakenStringBuilder+" nanoseconds");

        long stringBufferStartTime = System.nanoTime();
        stringBufferConcatenation(string, iterations);
        long stringBufferEndTime = System.nanoTime();
        long timeTakenStringBuffer = stringBufferEndTime - stringBufferStartTime;
        System.out.println("Time taken by string buffer to concatenate: "+timeTakenStringBuffer+" nanoseconds");

        long stringStartTime = System.nanoTime();
        stringConcatenation(string, iterations);
        long stringEndTime = System.nanoTime();
        long timeTakenString = stringEndTime - stringStartTime;
        System.out.println("Time taken by string to concatenate: "+timeTakenString+" nanoseconds");
    }

    public static void main(String[] args) {
        
        //Performing analysis
        System.out.println("Analysis for conacatenating 1000 times");
        analyze(1000);
        System.out.println();

        System.out.println("Analysis for conacatenating 10000 times");
        analyze(10000);
        System.out.println();

        System.out.println("Analysis for conacatenating 1000000 times");
        analyze(1000000);

    }
}
