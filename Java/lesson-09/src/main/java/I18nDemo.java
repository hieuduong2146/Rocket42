import java.text.NumberFormat;
import java.util.Locale;

public class I18nDemo {
    public static void main(String[] args) {
        double number = 123456.789;
        Locale vi = new Locale("vi","VN");
        Locale ja = new Locale("ja","JP");
        String a = formatNumber(number,vi);
        System.out.println("a = " + a);
        String b = formatNumber(number,ja);
        System.out.println("b = " + b);

    }

    public static String formatNumber(double number ,Locale locale){
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.format(number);
    }
}
