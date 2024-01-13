public class Studen {
    private final int id;
    private String name;
    public static String college;

    public static int count = 0;
    public Studen( String name) {
        if(count >= 7){
            throw  new IllegalStateException("Tao toi da 7 hoc sinh");
        }
        count += 1;
        this.id = count;
        this.name = name;
    }
    public final void stady(){
        System.out.println("Đang học bài...");
    }

    @Override
    public String toString() {
        return "Studen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", collec='" + college +
                '}';
    }
}
