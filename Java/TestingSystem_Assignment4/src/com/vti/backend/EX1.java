package com.vti.backend;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;

import java.time.LocalDate;

public class EX1 {
    public static void main(String[] args){
        //Question1
        Department department = new Department();
        Department department1 = new Department("IT");
        System.out.println(department1.getId());
        System.out.println(department1.getName());

        //Question2
        //a
        Account account = new Account();
        //b
        Account account1 = new Account(1,"aaa@","xxx","A", "Q", new Position(2, "CNTT"));
        System.out.println(account1.getFullName());
        //c
        Account account2 = new Account(2,"bbb@","Hieu","ccc","B",new Position(1,"dev"));
        System.out.println(account2.getId());
        System.out.println(account2.getEmail());
        System.out.println(account2.getUserName());
        System.out.println(account2.getLastName());
        System.out.println(account2.getFirsName());
        System.out.println(account2.getFullName());
        System.out.println(account2.getPosition().getName());
        System.out.println(account2.getPosition().getId());
         System.out.println(account2.getCreateDate());
        Account account3 = new Account(3,"bbb@","Hieu",
                "ccc","B",new Position(2,"dev"),LocalDate.of(2023, 12, 25));

        System.out.println("--------------");
        System.out.println(account3.getId());
        System.out.println(account3.getEmail());
        System.out.println(account3.getUserName());
        System.out.println(account3.getLastName());
        System.out.println(account3.getFirsName());
        System.out.println(account3.getFullName());
        System.out.println(account3.getPosition().getName());
        System.out.println(account3.getCreateDate());
        //Question 3


    }
}
