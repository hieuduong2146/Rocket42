package com.vti.entity;

public abstract class  AbstractPerson {
    private String name;
    private int age;

     public void printName(){
         System.out.println("name nay la tu abtract class");
     }

     public abstract int age();
}
