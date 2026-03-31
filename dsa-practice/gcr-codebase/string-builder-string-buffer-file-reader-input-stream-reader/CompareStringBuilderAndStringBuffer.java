public class CompareStringBuilderAndStringBuffer {

    public static void main(String[] args) {
        
        String string = "hello";
        final int ITERATIONS = 1000000;

        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();

        long startTimeBuilder = System.nanoTime();
        for(int i=0 ; i<ITERATIONS ; i++){
            stringBuilder.append(string);
        }
        long endTimeBuilder = System.nanoTime();
        long timeTakenByBuilder = endTimeBuilder - startTimeBuilder;

        long startTimeBuffer = System.nanoTime();
        for(int i=0 ; i<ITERATIONS ; i++){
            stringBuffer.append(string);
        }
        long endTimeBuffer = System.nanoTime();
        long timeTakenByBuffer = endTimeBuffer - startTimeBuffer;

        System.out.println("Time taken by string builder: "+timeTakenByBuilder+" nanoseconds");
        System.out.println("Time taken by string buffer: "+timeTakenByBuffer+" nanoseconds");
    }
}
