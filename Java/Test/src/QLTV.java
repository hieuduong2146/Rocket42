import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLTV implements IQLTV {

    private static Scanner scanner = new Scanner(System.in);

    private List<TaiLieu> taiLieus = new ArrayList<>();


    public static void main(String[] args) {
        QLTV qltv = new QLTV();
        while (true) {
            System.out.println("===QLTV===");
            System.out.println("1. Them moi tai lieu");
            System.out.println("2. Xoa tai lieu");
            System.out.println("3. Hien thi thong tin tai lieu");
            System.out.println("4. Tim kiem");
            System.out.println("5. Thoat");
            System.out.println("Moi ban nhap chuc nang:");
            int chon = scanner.nextInt();
            scanner.nextLine();
            switch (chon) {
                case 1:
                    qltv.themMoi();
                    break;
                case 2:
                    qltv.xoaTaiLieu();
                    break;
                case 3:
                    qltv.hienThi();
                    break;
                case 4:
                    qltv.timKiem();
                    break;
                case 5:
                    System.out.println("Thoat");
                    return;
                default:
                    System.out.println("Nhap sai, moi bạn nhap lai.");
                    break;
            }
        }
    }


    @Override
    public void themMoi() {
        System.out.println("Moi ban nhap ma tai lieu: ");
        String maTL = scanner.nextLine();
        System.out.println("Moi ban nhap ten tai lieu: ");
        String tenTL = scanner.nextLine();
        System.out.println("Moi ban nhap so ban phat hanh: ");
        int soBanPH = scanner.nextInt();
        System.out.println("Chon loai tai lieu: 1. Sach  2. Tap chi  3. Bao");
        int loai = scanner.nextInt();
        scanner.nextLine();

        switch (loai) {
            case 1:
                System.out.println("Moi ban nhap ten tac gia: ");
                String tenTG = scanner.nextLine();
                System.out.println("Moi ban nhap so trang: ");
                int soTrang = scanner.nextInt();
                TaiLieu sach = new Sach(maTL, tenTL, soBanPH, tenTG, soTrang);
                taiLieus.add(sach);
                break;
            case 2:
                System.out.println("Moi ban nhap so phat hanh: ");
                int soPH = scanner.nextInt();
                System.out.println("Moi ban nhap thang phat hanh: ");
                int thangPH = scanner.nextInt();
                scanner.nextLine();
                TaiLieu tapChi = new TapChi(maTL, tenTL, soBanPH, soPH, thangPH);
                taiLieus.add(tapChi);
                break;
            case 3:
                System.out.println("Moi ban nhap ngay phat hanh: ");
                String ngayPHString = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate ngayPH = LocalDate.parse(ngayPHString, formatter);
                TaiLieu bao = new Bao(maTL, tenTL, soBanPH, ngayPH);
                taiLieus.add(bao);
                break;
        }
        System.out.println("Them thanh cong");

    }

    @Override
    public void xoaTaiLieu() {
        System.out.println("Nhap ma tai lieu can xoa:");
        String maTL = scanner.nextLine();
        boolean check = false;
        for (TaiLieu t : taiLieus) {
            if (t.getMaTL().equals(maTL)) {
                taiLieus.remove(t);
                check = true;
                break;
            }
        }
        if (check)
            System.out.println("Xoa thanh cong");
        else
            System.out.println("Nhap sai ma tai lieu");

    }

    @Override
    public void hienThi() {
        System.out.println("Danh sách các tai lieu la:");
        for (TaiLieu tailieu : taiLieus) {
            System.out.println(tailieu.toString());
        }
    }

    @Override
    public void timKiem() {
        System.out.println("Moi ban chon loai can tim:  1.Sach   2.Tap chi   3.Bao");
        int loai = scanner.nextInt();
        scanner.nextLine();
        for (TaiLieu tailieu : taiLieus) {
            if (loai==1 && tailieu instanceof Sach)
                System.out.println(tailieu.toString());
            else if (loai==2 && tailieu instanceof TapChi)
                System.out.println(tailieu.toString());
            else if (loai  ==3 && tailieu instanceof Bao)
                System.out.println(tailieu.toString());
        }
    }
}