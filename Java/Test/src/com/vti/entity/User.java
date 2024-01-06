package com.vti.entity;

import java.time.LocalDate;

public class User {
    private String userName;
    private LocalDate joinDate;
    public User(LocalDate joinDate,String userName){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}
