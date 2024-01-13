package util;

public class Deparment {
    private int id;
    private String name;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Deparment(){
        System.out.println("Mời bạn nhập vào thông tin phòng ban");
        ScannerUtil util = new ScannerUtil();
        this.id = util.inputInt();

        System.out.println("Nhập vào name");
        this.name = util.inputString();
    }

    @Override
    public String toString() {
        return "Deparment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
