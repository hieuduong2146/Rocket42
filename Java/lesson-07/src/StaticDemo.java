public class StaticDemo {
    public static void main(String[] args) {
       //1.Truy cập qua tên class
        int max = MyMath.max(1,100);
        System.out.println("max = " + max);
        System.out.println("MyMath.PI = " + MyMath.PI);
        // 2. Bộ nhớ chỉ được giai phóng khi ct kết thúc
        Studen studen1 = new Studen("huy");
        System.out.println("studen1 = " + studen1);
        Studen studen2 = new Studen("cuong");
        System.out.println("studen1 = " + studen2);
    }
}
