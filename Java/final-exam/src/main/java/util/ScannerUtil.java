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

    public static String inputFullName() {
        while (true) {
            String input = inputString();
            if(hasAllAlphabeticCharacters(input)) {
                return input;

            } else {
                System.err.println("Yêu cầu chỉ nhập chữ");
                System.err.println("Nhập lại");
            }
        }

    }

    private static boolean hasAllAlphabeticCharacters(String s) {
        int length = s.length();
        for(int i = 0 ; i < length ; i ++) {
            char c = s.charAt(i);
            if(Character.isWhitespace(c)) {
                continue;
            }
            if(!Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }

    public static String inputEmail(){
        while (true) {
            String input = inputString();
            if(input.contains("@")) {
                return input;
            }
            System.out.println("Yêu cầu email phai có @");
            System.out.println("nhập lại");
        }

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

    public static String inputPassword() {
        while (true) {
            String input = inputString();
            int lenght = input.length();

            if (lenght < 6 || lenght > 12) {
                System.err.println("Yeu cau password tu 6 > 12 ki tu");
                System.err.println("Nhap lai");
            } else if (hasAnyUpperCharacter(input)) {
                return input;
            } else {
                System.err.println("yeu cau password it nhat 1 ki tu viet hoa");
                System.err.println("nhap lai");
            }

        }
    }

    private static boolean hasAnyUpperCharacter(String s) {
        int length = s.length();
        for (int i =0;i < length;i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
}
