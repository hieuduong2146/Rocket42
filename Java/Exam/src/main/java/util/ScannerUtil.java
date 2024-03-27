package util;


import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static String inputString() {
        //
        return SCANNER.nextLine().
                trim().
                replaceAll("\\s+"," ");
    }
    public static int inputInt(){
        while (true){
            try {
                String input = inputString();
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.err.println("Yêu cầu nhập vào số  nguyên");
                System.err.println("Vui lòng nhâp lại");
            }
        }

    }

    public static String inputEmail() {
        while (true) {
            String input = inputString();
            if(input.contains("@")) {
                return input;
            }
            System.out.println("Yêu cầu email phai có @");
            System.out.println("Nhập lại");
        }

    }

    public static String inputPassword() {
        while (true) {
            String input = inputString();
            int lenght = input.length();
            if (lenght < 6 || lenght > 12) {
                System.err.println("Yêu cầu nhập password từ 6 > 12 kí tự");
                System.err.println("Nhập lại");
            }
            return input;
        }
    }
}