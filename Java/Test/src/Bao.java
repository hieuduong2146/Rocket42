import java.time.LocalDate;

public class Bao extends TaiLieu{

    private LocalDate ngayPH;

    public Bao(String maTL, String tenTL, int soBanPH, LocalDate ngayPH) {
        super(maTL, tenTL, soBanPH);
        this.ngayPH = ngayPH;
    }

    public LocalDate getNgayPH() {
        return ngayPH;
    }

    public void setNgayPH(LocalDate ngayPH) {
        this.ngayPH = ngayPH;
    }
}