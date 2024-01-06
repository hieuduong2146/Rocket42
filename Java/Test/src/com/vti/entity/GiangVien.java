package com.vti.entity;

import java.time.LocalDate;

public class GiangVien extends User {
    private LocalDate joinDate;

    public GiangVien(LocalDate joinDate, String userName) {
        super(joinDate, userName);
    }

    public LocalDate getJoinDate(){
       return joinDate.minusDays(1);
   }

}
