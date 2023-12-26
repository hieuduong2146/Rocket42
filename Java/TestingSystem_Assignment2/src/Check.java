import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Check {

    public static void main(String[] args) {
        /*int a = 1;
        int b = 2;
        int x = a/b;
        System.out.println(x);
        float a1 = (float) a;
        System.out.println(a1);
        float c = a1/b;// 0.5
        System.out.println(c);*/

//        int maxInt = Integer.MAX_VALUE;
//        System.out.println(maxInt);
//
//        long x = (long)maxInt + 1;
//        System.out.println(x);
//
//        int y = (int) x;
//        System.out.println(y);

//        int r = ThreadLocalRandom.current().nextInt(0, 100000);// 0 - 99999
//        System.out.println(r);
//        while (r < 10000) {
//            r = r * 10;
//        }
//        System.out.println(r);

          /*int a = 0;
          int b;

          b = 2;

          System.out.println(a/b);

          Integer x = 0;
          Integer y;
          y = 2;

          System.out.println(x/y);*/


//        int a = 5;
//        Integer a1 = 5;
//        Integer a2 = new Integer(5);
//        Integer a3 = new Integer(5);

//        System.out.println(a == a1);
//        System.out.println(a == a3);

//        System.out.println(a1 == a2);
//        System.out.println(a1 == a3);
//        System.out.println(a2 == a3);

//        System.out.println(a1.equals(a2));
//        System.out.println(a1.equals(a3));
//        System.out.println(a2.equals(a3));


        /*String x = "abcd";
        String y = "abc";
        y = y + "d";
        System.out.println(x == y);
        System.out.println(x.equals(y));

        int k = 10;
        Integer p = Integer.valueOf(k);
        System.out.println("p la boxing cua k");

        int j = p.intValue();
        System.out.println("j la unboxing cua p");*/

        /*Integer p = 5;
        Integer q = 6;
        System.out.println(p.compareTo(q) > 0 ? p + " lon hon " + q : p + " ko lon hon " + q);


        System.out.println(p.compareTo(q));

        p = 6;
        q = 5;
        System.out.println(p.compareTo(q));


        p = 5;
        q = 5;
        System.out.println(p.compareTo(q));*/

        /*String x = "Le Van A";
        String y = "Le Van B";
        System.out.println(x.compareTo(y));

        String z = "121212";
        Integer zz = Integer.parseInt(z);

        Long zzz = Long.parseLong(z);*/

        /*String x = "Mã hóa String này thành dãy các byte liên tục bởi sử dụng " +
                "bộ ký tự mặc định của platform, lưu giữ kết quả vào trong một mảng byte mới";

        String[] arr = x.split(" ");
        int size = arr.length;
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(i + " " + arr[i]);
        }*/

//        Integer x = new Integer(5);
//        Integer y = new Integer(6);
//
//        System.out.println(x.toString());
//        System.out.println(x.hashCode());
//        System.out.println(x.equals(y));

        User user = new User();
        user.id = 1;
        user.userName = "test";

        System.out.println(user.toString());
        System.out.println(user.hashCode());

        User user1 = new User();
        user1.id = 1;
        user1.userName = "ABC";

        System.out.println(user.equals(user1));

        User user2 = new User();
        user2.id = 2;
        user2.userName = "CDE";

        User user3 = new User();
        user3.id = 3;
        user3.userName = "BCD";

        // user1, user2, user3
        // user 1 - ABC
        // user 3 - BCD
        // user 2 - CDE

        if (user1.userName != null && user3.userName != null) {
//            System.out.println(user1.userName.compareTo(user3.userName));
//            System.out.println(user1.compareTo(user3));
//            System.out.println(Objects.compare(user1, user3, new User()));
        }

//        System.out.println(user3.userName.compareTo(user2.userName));

//        System.out.println(user1.userName.compareTo(user3.userName));

//        Collections.sort(list, new CompareName());
//        Collections.sort(list, new CompareAge());


    }
}
