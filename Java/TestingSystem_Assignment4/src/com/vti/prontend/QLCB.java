package com.vti.prontend;

import java.util.ArrayList;

public class QLCB {
    ArrayList<CanbBo> list;

    public QLCB (){
        list = new ArrayList<>();
    }
    public void addCanbo(CanbBo canbBo){
        list.add(canbBo);

    }
    public CanbBo findByFullName(String hoten){
        for (CanbBo canbo : list) {
            if (canbo.getHoTen().equals(hoten)) {
                return  canbo;
            }
        }
        return null;

    }
    public void hienThi() {
        for (CanbBo canbBo : list) {
            System.out.println(canbBo.toString());
        }
    }

    public CanbBo deleteByFullName(String hoten){
        for (CanbBo canbo : list) {
            if (canbo.getHoTen().equals(hoten)) {
                list.remove(canbo);
                return  canbo;
            }
        }
        return null;

    }
}
