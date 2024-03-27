public class test {
    private void a (int w){
        System.out.println(w);
    }
    private final void a (){
        System.out.println(10);
    }

    public static void main(String[] args) {
        test b = new test();
        int c = 3/0 ;
        System.out.println(c);


    }
}
