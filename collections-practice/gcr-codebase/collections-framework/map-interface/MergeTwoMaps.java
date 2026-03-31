import java.util.HashMap;
import java.util.Map;

public class MergeTwoMaps {
    
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2){
        Map<String, Integer> merged= new HashMap<>();

        for(Map.Entry<String, Integer> entry: map1.entrySet()){
            merged.put(entry.getKey(), entry.getValue());
        }

        for(Map.Entry<String, Integer> entry: map2.entrySet()){
            merged.put(entry.getKey(), merged.getOrDefault(entry.getKey(), 0)+entry.getValue());
        }

        return merged;
    }
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        map1.put("A",1);
        map1.put("B",2);
        map2.put("B",3);
        map2.put("C",4);

        Map<String, Integer> merged = mergeMaps(map1, map2);

        System.out.println("Map1: "+map1);
        System.out.println("Map2: "+map2);
        System.out.println("Merged map: "+merged);
    }
}
