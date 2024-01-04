package com.vti.entity;

import java.util.List;

public abstract class Phone {

    List<Contact> contacts;

    public abstract void insertContact(String name, String phone);
    public abstract void removeContact(String name);
    public abstract void updateContact(String name, String newPhone);
    public abstract String searchContact(String name);

}