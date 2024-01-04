public class TapChi extends TaiLieu {
    private int soPH;
    private int thangPH;

    public TapChi(String maTL, String tenTL, int soBanPH, int soPH, int thangPH) {
        super(maTL, tenTL, soBanPH);
        this.soPH = soPH;
        this.thangPH = thangPH;
    }

    public int getSoPH() {
        return soPH;
    }

    public void setSoPH(int soPH) {
        this.soPH = soPH;
    }

    public int getThangPH() {
        return thangPH;
    }

    public void setThangPH(int thangPH) {
        this.thangPH = thangPH;
    }
}
