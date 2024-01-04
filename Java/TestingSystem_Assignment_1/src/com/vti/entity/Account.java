package com.vti.entity;

import java.util.Date;

public class Account {
    private long AccountId;
    private String email;
    private String lastName;
    private String firsName;
    private String fullName;
    private Department department;
    private Position position;
    private Date createDate;
    private Group[] groups;
    private Gender gender;
    private int salary;

    public Account(){

    }
    public Account(long id , String firsName,String email,String lastName){
        this.AccountId = id;
        this.firsName = firsName;
        this.email = email;
        this.lastName = lastName;
        this.fullName = firsName+lastName;


    }
    public void  setFullName(){
        this.fullName = fullName;
    }
    public String getFullName(){
        return this.fullName;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getSalary(){
        return this.salary;
    }
}
