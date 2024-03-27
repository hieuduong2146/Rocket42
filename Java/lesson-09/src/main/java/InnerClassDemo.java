public class InnerClassDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.dispaly();
        Outer.Inner inner = outer.new Inner();
        inner.display();
    }


}
