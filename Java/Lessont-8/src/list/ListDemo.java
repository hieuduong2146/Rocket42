package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        //  List<Integer> list = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0,4);
        System.out.println(list);
//        for (Integer i : list) {
//            System.out.println("i = " + i);
//        }
        int size = list.size();
        System.out.println("size = " + size);
        boolean isEmpty = list.isEmpty();
        System.out.println("isEmpty = " + isEmpty);

        //lay phan tu theo chi so
        int element = list.get(2);
        System.out.println("element = " + element);
        list.remove(0);
        list.clear();

    }
}
