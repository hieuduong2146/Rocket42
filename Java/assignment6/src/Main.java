import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws MyException {
//        System.out.println();
//        IParent iParent ;
//
//        iParent = new ChildClass("123-123-123","Axx Bxx Cxx");
//
//        iParent.dispalyInfor();
//
//        System.out.println(iParent.getIdentity());
//        Scanner scanner = new Scanner(System.in);
//        if(iParent.getColor() == null){
//            System.out.println("Hay nhap vao color");
//
//            String input = scanner.next();
//            Color color;
//            try {
//                color = Color.valueOf(input);
//
//            } catch(IllegalArgumentException illegalArgumentException) {
//
//                System.out.println(illegalArgumentException.getMessage());
//                color = Color.GREEN;
//            }  finally {
//                System.out.println("Finaly luon thuc hien");
//            }
//            iParent.setColor(color);
//            System.out.println(iParent.getIdentity() + iParent.getColor());

//        }
//        iParent.readFile("abc.txt");
        try {
            checkNumber(18);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkNumber ( int n) throws MyException {
        if (n < 18) {
            throw new MyException("Duoi 18 thi khong duoc vao quan bar");
        } else {
            System.out.println("Tu 18 tuoi thi duoc vao quan bar");
        }
    }
}