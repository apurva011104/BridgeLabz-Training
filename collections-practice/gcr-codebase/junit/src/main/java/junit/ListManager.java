package junit;

import java.util.List;

public class ListManager {
    
    public static boolean addElement(List<Integer> list, int element){
        try {
            list.add(element);
            return true;
        } 
        catch (Exception e) {
            return false;
        }
    }

    public static boolean removeElement(List<Integer> list, int element){
        int count = 0;
        int index=0;
        while(index<list.size()){
            if(list.get(index)==element){
                list.remove(index);
                count++;
            }
            else{
                index++;
            }
        }
        return count==0;
    }

    public static int getSize(List<Integer> list){
        int index = 0;
        try { 
            while (true) { 
                list.get(index);
                index++;
            }
        } catch (Exception e) {}
        return index;
    } 
}
