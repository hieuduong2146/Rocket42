package generic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        // T : type
        // E : Element
        // N : Number
        // K : key
        // V : value
        Circle<Integer> c1 = new Circle<>(10, "red");
        System.out.println("c1 = " + c1);

        Circle<Double> c2 = new Circle<>(20.5, "blue");
        System.out.println("c2 = " + c2);

        // wildcard : extend , super , ?

//        Circle<String> c3 = new Circle<>("abc", "green");
//        System.out.println("c3 = " + c3);

        print(4);
        print(4.5);
        print("abc");
        List<Integer> list = Arrays.asList(1,2,3);
        printSize(list);
    }
    public static <T> void print(T a){
        System.out.println(a);
    }
    public static void printSize(List<?> list){
        System.out.println("list.size() = " + list.size());
    }
}