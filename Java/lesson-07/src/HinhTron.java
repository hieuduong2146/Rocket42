public class HinhTron extends HinhHoc{
    private double banKinh;

    public HinhTron(double banKinh) {
        super();
        this.banKinh = banKinh;
    }

    @Override
    public double tinhChiVi() {
        return 2 * banKinh * Math.PI;
    }

    @Override
    public double tinhDienTich() {
        return banKinh * banKinh * Math.PI;
    }
}
