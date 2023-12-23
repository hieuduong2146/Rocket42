import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DayTwo {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println(">>> nhập vào id của người dùng");
        boolean flag = scanner.hasNextLong();
        if(flag){
            System.out.println("Bạn nhập đúng rồi");

        }else{
            System.out.println("Bạn nhập sai rồi");
            System.exit(0);
        }

        AccountDao accountDao = new AccountDao();
        Account account = accountDao.getAccount(1);
        if (account == null){
            System.out.println("Người này khng có trong database");
        }else {
            System.out.println(">>> Thông tin của người dùng");
            System.out.println("ID:" + account.AccountId);
            System.out.println("Full name:" +account.fullName);
            System.out.println(" name:" +account.userName);
            System.out.println(" Date:" +account.createDate);

            Date currentDate = new Date();
            System.out.println(" current Date:" + currentDate);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String homnay = simpleDateFormat.format(currentDate);
            System.out.println(homnay);

            long ngauNhien = ThreadLocalRandom.current().nextLong(10000000);
            System.out.println(ngauNhien);
            ngauNhien = ThreadLocalRandom.current().nextLong(100);
            System.out.println(ngauNhien);
            ngauNhien = ThreadLocalRandom.current().nextLong(50,100);
            System.out.println(ngauNhien);

            LocalDate localDate = LocalDate.of(2023,11,20);
            LocalTime localTime = LocalTime.now();
            System.out.println(localTime);
             localTime = LocalTime.MAX.plus(44, ChronoUnit.MINUTES);
            LocalDateTime localDateTime= LocalDateTime.now( );
            System.out.println(localDateTime);
            localDate.plus(12, ChronoUnit.DAYS);
            System.out.println(localDate);


            boolean z = true;
            String r = z ? "true" : "false";
            System.out.println(r);
        }
        int gt = 0;
        switch (gt){
            case 0 :
                System.out.println("Male");
                break;
            case 1:
                System.out.println("Female");
                break;
            default:
                System.out.println("UNKNOW");

        }
        String[] arr = account.fullName.split(" ");
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
            if(i == 0){
                break;
            }
        }
        char[] chars = account.fullName.toCharArray();
//        for(char c : chars){
//            if(c == ' '){
//                continue;
//            }
//           System.out.println(c);
//        }
        int i = 0;
        int size = chars.length;
//        while (i < size){
//            System.out.println(chars[i]);
//            i++;
//
//        }
        int j = 0;

        do {
            System.out.println(chars[j]);
            j++;
        }while (j < size);





    }

}
