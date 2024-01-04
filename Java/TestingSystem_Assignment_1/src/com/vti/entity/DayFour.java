package com.vti.entity;

public class DayFour {
    public static void main(String[] args){
        Studen studen = new Studen(14,"user1");
        System.out.println(studen.id);
        System.out.println(studen.userName);

        Department department = new Department();
        Department department1 = new Department("IT");
        System.out.println(department.departmentId);
        System.out.println(department.departmentName);

        Account account = new Account(1,"aaa","bbb@","ccc");
        System.out.println(account.getFullName());

        account.setSalary(1200);
       System.out.println( account.getSalary());

       Person person = new Person("Tran van A",18);
       Emploee emploee = new Emploee("Tran van 888",19);
       System.out.println(emploee.getName());

//        Vehicle vehicle = new Vehicle();
//        vehicle.fill();
        For aFor = new For();
        aFor.fillGas();
    }




}
