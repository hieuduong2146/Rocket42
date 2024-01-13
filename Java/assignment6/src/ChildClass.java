import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ChildClass implements IParent{
    private String indentity;
    private String name;
    private Color color;

    public ChildClass(String indentity, String name) {
        this.indentity = indentity;
        this.name = name;
    }

    @Override
    public void dispalyInfor() {
        System.out.println("Identity" + getIdentity());
        System.out.println("Name" + name);
    }

    @Override
    public String getIdentity() {

        return this.indentity;
    }

    @Override
    public Color getColor() {

        return this.color;
    }

    @Override
    public void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader("abc.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }


}
