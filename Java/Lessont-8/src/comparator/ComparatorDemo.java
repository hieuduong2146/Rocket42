package comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(2);
        list.add(8);
        list.add(5);
        list.add(3);
        list.add(1);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               // return Integer.compare(o1,o2);
                return Integer.compare(o2,o1);
            }
        });
        System.out.println("list = " + list);


    }
}
