public class FinalDemo {
    public static void main(String[] args) {
        //1.biến tham số:tạo hằng số
        final double pi = 3.14;
        //2.Phương thứ : Class con không thể ghi đè phương thức đó
        Dog dog = new Dog();
        dog.sleep();
        //3.Class:Đánh dấu class đó kh có class con
    }
}
