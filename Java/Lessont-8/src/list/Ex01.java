package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ex01 {
    public static void question1(){
        List<Studen> studen = new ArrayList<>();
        studen.add(new Studen("A"));
        studen.add(new Studen("b"));
        studen.add(new Studen("c"));
        studen.add(new Studen("d"));
        int size = studen.size();
        System.out.println("size = " + size);
        Studen element = studen.get(3);
        System.out.println("element = " + element);
        Studen firsStuden = studen.get(0);
        System.out.println("studen1 = " + firsStuden);
        int lastIndex = size - 1;
        Studen lasStuden = studen.get(lastIndex);
        System.out.println("lasStuden = " + lasStuden);
        Studen newStuden = new Studen("Huong");
        studen.add(0,newStuden);
        studen.add(newStuden);
        Studen studen2 = findById(studen,2);
        System.out.println("studen2 = " + studen2);
        Studen studen3 = findName(studen,"A");
        System.out.println("studen3 = " + studen3);

        List<Studen> newStudens = new LinkedList<>();
        for (int i = studen.size() - 1; i >= 0;i--){
            Studen s = studen.get(i);
            newStudens.add(s);
        }
        System.out.println(studen);
        System.out.println(newStudens);
//thu vien
        Collections.reverse(studen);

        List<Studen> studentCopies = new ArrayList<>();
        studentCopies.addAll(studen);
        System.out.println("studentCopies = " + studentCopies);

        for (Studen studen1 : studen) {
            if(studen1.getId() == 2){
                studen1.setName(null);
                System.out.println("Da xoa thanh cong");
            }
        }


        studen.removeIf(studen1 -> studen1.getId() == 5);
    }


    public static Studen findById(List<Studen> studens,int id){
        for (Studen studen : studens) {
            if (studen.getId() == id){
                return studen;
            }
        }
        return null;
    }

    public static Studen findName(List<Studen> studens,String name){
        for (Studen studen : studens) {
            if (studen.getName().equals(name)){
                return studen;
            }
        }
        return null;
    }
}
