import java.io.*;

public class IOSTreamDemo {
    public static void main(String[] args) throws IOException {
        String path = "abc.txt";
        String content = "Rocket 42";
        writeFile(path,content,true);
        String result = readFile(path);
        System.out.println("result = " + result);
    }
    public static String readFile(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        String content = ois.readUTF();
        ois.close();
        return content
;    }
    public static void writeFile(
            String path,String content,boolean append) throws IOException {
        FileOutputStream fos = new FileOutputStream(path,append);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeBytes(content);
        oos.close();
    }


}
