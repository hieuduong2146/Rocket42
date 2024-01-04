package com.vti.entity;

public class Emploee extends Person{
    public  Emploee(String name , int age){
        super(name,age);
    }
    public String getName(){
        return this.name;
    }
}
