import java.util.concurrent.ThreadLocalRandom;

public class Exercise1 {
    public static  void  main(String[] args){
        System.out.println("<<<Question1");
        float account1 = 5240.5f;
        float account2 = 10970.055f;
        int ac1 = (int)account1;
        int ac2 = (int)account2;

        System.out.println(ac1);
        System.out.println(ac2);

        System.out.println("<<<Question2");
        Long ngauNhien = ThreadLocalRandom.current().nextLong(0,99999);
        long ngauNhien1 = 0;
        if (ngauNhien < 10000) {
            ngauNhien1 = ngauNhien * 10;
            System.out.println(ngauNhien1);
        } else {
            System.out.println(ngauNhien);
        }

        System.out.println("<<<Question3");

            long x = ngauNhien%100;
         System.out.println(x);

        System.out.println("<<<Question4");

        int thuong = Method.thuongHaiso(4,2);
        System.out.println(thuong);

    }

}
