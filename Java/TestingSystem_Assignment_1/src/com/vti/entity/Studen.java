package com.vti.entity;

public class Studen {
    long id ;
    String userName;
    public Studen(){

    }

    public Studen(long id){
        this.id = id;
    }

    public Studen(long id,String userName){
        this.id = id;
        this.userName = userName;
    }
}
