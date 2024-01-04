import java.util.Scanner;

public class Exercise4 {
    public  static  void  main(String[] args) {
        System.out.println("<<<<Question1");
        String s = "Hôm nay trời đẹp nhỉ ,bạn có thể đi chơi cùng tôi được không";
        String[] arr = s.split(" ");
        int size = arr.length;
        System.out.println("Có tổng cộng " + size + " kí tự  trong mảng");

        System.out.println("<<<<Question2");
        String s1 = "Hôm nay trời đẹp nhỉ";
        String s2 = "Bạn có thể đi chơi cùng tôi không";
        System.out.println(s1 + " " + s2);

        System.out.println("<<<<Question3");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập vào họ và tên");
        String fullname = scanner.nextLine().trim();
        fullname = fullname.toLowerCase();
        String[] fullName = fullname.split(" ");
        String result = "";
        for (String f : fullName) {
            result += String.valueOf(f.charAt(0)).toUpperCase() + f.substring(1) + " ";
            System.out.println(result);




        }


//        System.out.println("<<<<Question4");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Hãy nhập vào họ và tên");
//        String fullname = scanner.nextLine().trim();
//        String[] fullName = fullname.split(" ");
//        String name =  fullName[fullName.length - 1];
//        String[] nameArr = name.split("");
//        int size1 = nameArr.length;
//        for (int i = 1; i <= size1; i++) {
//            System.out.println("Ký tự thứ "+ i + " là: "+nameArr[i-1]);
//        }

//        System.out.println("<<<<Question6");
//        Scanner scanner1 = new Scanner(System.in);
//        System.out.println("Hãy nhập vào họ và tên");
//        String hoVaTen = scanner.nextLine().trim();
//        String[] fullnameArr = hoVaTen.split(" ");
//        for (int i = 0; i <= fullnameArr.length; i++) {
//            System.out.println("Họ là :" + fullnameArr[0]);
//            System.out.println("Đệm là :" + fullnameArr[i + 1]);
//            System.out.println("Tên là :" + fullnameArr[i + 2]);
//            break;

    }

}
