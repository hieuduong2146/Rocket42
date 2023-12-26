import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class DayThree {
    public static void main(String[] args) {
        /*int a = 1;
        int b = 2;
        int x = a/b;
        System.out.println(x);
        float a1 = (float)a/b;
        System.out.println(a1);
        float c = a1/b;
        System.out.println(c);*/

           /* int maxInt = Integer.MAX_VALUE;
            System.out.println(maxInt);

            long x = (long)maxInt + 1 ;
            System.out.println(x);

            int y = (int)x;
            System.out.println(y);*/
        /*System.out.println(">>> Question1");
        float Account1 = 5240.5F;
        float Account2 = 10970.055F;
        int ac1 = (int)Account1;
        System.out.println(ac1);
        int ac2 = (int)Account2;
        System.out.println(ac2);*/

       /* System.out.println(">>> Question2");
        long ngauNhien = ThreadLocalRandom.current().nextLong(99999);
        long ngauNhien1 = 0;
        if (ngauNhien < 9999) {
            ngauNhien1 = ngauNhien * 10;
            System.out.println(ngauNhien1);
        } else {
            System.out.println(ngauNhien);
        }*/

       /* int a = 0;
        int b  ;
        b= 2;
        System.out.println(a/b);

        Integer x = 0;
        Integer y;
        y = 2;
        System.out.println(x/y);*/

     /*   int a = 5;
        Integer a1 = 5;
        Integer a2 = new Integer(5);
        Integer a3 = new Integer(5);

        System.out.println(a == a1);
        System.out.println(a == a3);
        System.out.println(a1 == a2);
        System.out.println(a1 == a3);
        System.out.println(a1.equals(a3) );
        String x =  "abcd";
        String y = "abc";
        y = y + "d";
        System.out.println(x == y);
        System.out.println(x.equals(y) );

        int k = 10;
        Integer p = Integer.valueOf(k);
        System.out.println("p la boxing cua k");

        int j = p.intValue();
        System.out.println("j la unboxing p ");*/

       /* Integer p  = 5;
        Integer q = 6;
        System.out.println(p.compareTo(q) > 0 ? p + "lon hon " + q : p + " khong lon hon " + q );*/
/*
        String x = "Le van A";
        String y = "Le van B";
        System.out.println(x.compareTo(y));*/
       /* String a = "Duong Minh Hieu";
        String[] arr = a.split(" ");
        int size = arr.length;
       System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println( i + "" + arr[i]);
        }*/
        User user = new User();
        user.id = 1;
        user.userName = "Test";
        User user1 = new User();
        user1.id = 1;
        user.userName = "Axx";
        User user2 = new User();
        user2.id = 2;
        user.userName = "Cxx";
        User user3 = new User();
        user3.id = 3;
        user.userName = "Bxx";

//        System.out.println(user.toString());
        if(user1.userName != null&& user3.userName != null){


        }
//        System.out.println(user3.userName.compareTo(user2.userName));
//        System.out.println(user1.userName.compareTo(user3.userName));


    Department department1 = new Department();
        department1.departmentName = "test1";
        Department department2 = new Department();
        department2.departmentName = "test2";
        if(department1.equals(department2)){
            System.out.println("2 dept bang nhau");
        } else {
            System.out.println("2 dept khac nhau");
        }
    }


}
