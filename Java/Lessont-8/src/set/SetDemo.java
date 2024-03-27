package set;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println("set.size() = " + set.size());
        System.out.println("set = " + set);
    }
}
