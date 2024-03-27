package com.vti.prontend;

public class CanbBo {
    private String nameCanBo;
    private String hoTen;
    private int tuoi;
    private GioiTinh gioiTinh;
    private String address;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Override
    public String toString() {
        return "CanbBo{" +
                "nameCanBo='" + nameCanBo + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", tuoi=" + tuoi +
                ", gioiTinh=" + gioiTinh +
                ", address='" + address + '\'' +
                '}';
    }
    public void talk(){
        System.out.println("a");
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        if(tuoi > 0 && tuoi <= 100){
            this.tuoi = tuoi;
        }
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
