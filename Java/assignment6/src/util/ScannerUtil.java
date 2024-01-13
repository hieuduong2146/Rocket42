package util;

import java.util.Scanner;

public class ScannerUtil {
   private Scanner scanner = new Scanner(System.in);
    public int inputAge(){
        while (true){
            try {
                String input = scanner.nextLine();
                int age = Integer.parseInt(input);
                if(age < 0){
                    System.out.println("The age must be greater than 0 , input again.");
                } else {
                    return age;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Pls input an age as int,input again.");
            }
        }

    }
    public int inputInt(){
        while (true){
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.err.println("Yêu cầu nhập vào số nguyên. Nhập lại");
            }

        }
    }

    public float inputFloat(){
        while (true){
            try {
                String input = scanner.nextLine();
                return Float.parseFloat(input);
            } catch (NumberFormatException exception) {
                System.err.println("Yêu cầu nhập vào số thực. Nhập lại");
            }

        }
    }

    public double inputDouble(){
        while (true){
            try {
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException exception) {
                System.err.println("Yêu cầu nhập vào số thực. Nhập lại");
            }

        }
    }

    public String inputString(){
      return scanner.nextLine();
    }
}
