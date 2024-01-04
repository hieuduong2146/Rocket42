import java.util.Scanner;

public class Test {
    public  static  void  main(String[] args){

        System.out.println("<<<<Question6");
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Hãy nhập vào họ và tên");
        String hoVaTen = scanner1.nextLine().trim();
        String[] fullnameArr = hoVaTen.split(" ");
        for (int i = 1; i <= fullnameArr.length; i++) {
            System.out.println("Họ là :" + fullnameArr[1]);
            System.out.println("Đệm là :" + fullnameArr[2] )   ;
            System.out.println("Tên là :" + fullnameArr[(fullnameArr.length -1)]);
            break;
        }
    }
}
