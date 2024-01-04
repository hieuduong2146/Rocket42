public class Sach extends TaiLieu{

    private String tenTG;
    private int soTrang;

    public Sach(){

    }

    public Sach(String maTL, String tenTL, int soBanPH, String tenTG, int soTrang) {
        super(maTL, tenTL, soBanPH);
        this.tenTG = tenTG;
        this.soTrang = soTrang;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }
}
