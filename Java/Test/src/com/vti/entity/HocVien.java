package com.vti.entity;

import java.time.LocalDate;

public class HocVien extends User{
    public HocVien(LocalDate joinDate,String username){
        super(joinDate,username);
    }
    public LocalDate getUserInfor(){
        return super.getJoinDate();
    }

}
