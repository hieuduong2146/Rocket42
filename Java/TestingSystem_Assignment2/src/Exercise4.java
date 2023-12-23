import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Exercise4 {
    public static void main(String[] args) {
        System.out.println(">>> Question1");
        long ngauNhien = ThreadLocalRandom.current().nextLong(100);
        System.out.println("Số nguyên ngẫu nhiên là :" + ngauNhien);
        System.out.println(">>> Question2");
        double ngauNhien1 = ThreadLocalRandom.current().nextDouble();
        System.out.println("Số thực ngẫu nhiên là :" + ngauNhien1);
        System.out.println(">>> Question3");

        String[] arr = {"Axx","Bxx","Cxx","Dxx","Exx","Fxx","Gxx","Hxx"};
        long num = ThreadLocalRandom.current().nextLong(9);
        System.out.println("Tên ngẫu nhiên bạn trong lớp là : "+arr[(int) num - 1]);

        
    }

}
