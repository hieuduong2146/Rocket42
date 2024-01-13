public abstract class HinhHoc {
    private static int count;

    public HinhHoc() {
        if(count >= Configs.SO_LUONG_HINH_TOI_DA){
            throw new HinhHocException("So luong hinh toi da la :" + Configs.SO_LUONG_HINH_TOI_DA);
        }
        count ++;
    }

    public abstract double tinhChiVi();
    public abstract double tinhDienTich();

}
