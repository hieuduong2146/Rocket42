public class TryCatchFinally {
    public static void main(String[] args) {
        try {

            int[] num = {1,2,3};
            System.out.println("num[100] = " + num[100]);

            int c = 1/0;
            System.out.println("c = " + c);

            String s = null;
            System.out.println("s = " + s.trim());


        } catch (ArithmeticException exception){
            System.out.println("Khong the chia cho 0");
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
        } finally {
            System.out.println("Finally luon duoc goi");
        }
    }
}
