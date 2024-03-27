import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(4));
        Iterator i = list.iterator();
        Collections.reverse(list);
        while(i.hasNext()){
            System.out.println(i.next()+ "  ");
        }


    }

}