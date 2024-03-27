import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {

        //tao thu muc
        File folder = new File("C:/lesson7");
        folder.mkdir();
        File file = new File("C:/lesson7/abc.txt");
        //Tao file
        file.createNewFile();
        boolean exists = file.exists();
        System.out.println("exists = " + exists);
        String[] names = folder.list();
        for (String name : names) {
            System.out.println("name = " + name);
        }
        file.delete();
        exists = file.exists();
        System.out.println("exists = " + exists);
    }
}
