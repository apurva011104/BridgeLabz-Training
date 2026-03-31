import java.util.HashMap;
import java.util.Map;

public class FindKeyWithHighestValue {

    public static String findKey(Map<String, Integer> map){
        int max = Integer.MIN_VALUE;
        String str="";

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(max<=entry.getValue()){
                str=entry.getKey();
                max=entry.getValue();
            }
        }
        return str;
    }
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("A",10);
        map.put("B",20);
        map.put("C",15);

        System.out.println("Map: "+map);
        System.out.println("Key with highest value: "+findKey(map));
        
    }
}
