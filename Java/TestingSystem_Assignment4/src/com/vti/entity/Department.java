package com.vti.entity;

public class Department {
    private long id;
    private String name;

    public Department(String name) {
        this.id = 0;
        this.name = name;
    }

    public Department() {
        ;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
