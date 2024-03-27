package com.vti.prontend;

public class CongNhan extends CanbBo{
    private long bac;

    public long getBac() {
        return bac;
    }
    public void talk(){
        System.out.println("b");
    }
    public void setBac(long bac) {
        this.bac = bac;
    }

    public static void main(String[] args) {
        CanbBo cb = new CongNhan();
        cb.talk();
    }
}
