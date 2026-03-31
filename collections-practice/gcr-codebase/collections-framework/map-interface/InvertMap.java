import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertMap {

    public static Map<Integer, List<String>> invertMap(Map<String, Integer> map){
        Map<Integer, List<String>> inverted = new HashMap<>();

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            inverted.putIfAbsent(entry.getValue(), new ArrayList<>());
            inverted.get(entry.getValue()).add(entry.getKey());
        }
        return inverted;
    }
    
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("A",1);
        map.put("B",2);
        map.put("C",1);
        Map<Integer, List<String>> inverted = invertMap(map);

        System.out.println("Map: "+map);
        System.out.println("Inverted map: "+inverted);
    }
}
