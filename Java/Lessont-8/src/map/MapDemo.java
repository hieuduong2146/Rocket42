package map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("a",7);
        map.put("b",6);
        map.put("c",9);
        map.put("d",8);
        System.out.println("map.size() = " + map.size());
        System.out.println("map = " + map);
    }
}
