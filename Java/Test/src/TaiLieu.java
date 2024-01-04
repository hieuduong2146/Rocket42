public class TaiLieu {
    private String maTL;
    private String tenTL;
    private int soBanPH;

    public TaiLieu(){

    }

    public TaiLieu(String maTL, String tenTL, int soBanPH) {
        this.maTL = maTL;
        this.tenTL = tenTL;
        this.soBanPH = soBanPH;
    }

    public String getMaTL() {
        return maTL;
    }

    public void setMaTL(String maTL) {
        this.maTL = maTL;
    }

    public String getTenTL() {
        return tenTL;
    }

    public void setTenTL(String tenTL) {
        this.tenTL = tenTL;
    }

    public int getSoBanPH() {
        return soBanPH;
    }

    public void setSoBanPH(int soBanPH) {
        this.soBanPH = soBanPH;
    }

    @Override
    public String toString() {
        return "TaiLieu{" +
                "maTL='" + maTL + '\'' +
                ", tenTL='" + tenTL + '\'' +
                ", soBanPH=" + soBanPH +
                '}';
    }
}
