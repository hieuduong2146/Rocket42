public class Exercise3 {
    public static  void  main(String[] args){
        System.out.println("<<<Question1");
       Integer i = Integer.valueOf(5000);
       float f = i;
       System.out.println(f);

        System.out.println("<<<Question2");
        String s = "1234567";
        int intS = Integer.parseInt(s);
        System.out.println(intS);

        System.out.println("<<<Question3");
        Integer q = Integer.valueOf("1234567");
        int intQ = (int)q;
        System.out.println(intQ);
    }


}
