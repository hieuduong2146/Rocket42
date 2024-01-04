package com.vti.prontend;

public class Studen {

    private long id;
    private String name;
    private String hometow;
    private double point;

    public Studen(String name, String hometow) {
        this.name = name;
        this.hometow = hometow;
        this.point = 0;
    }
    public Studen(String name, String hometow,float point) {
        this.name = name;
        this.hometow = hometow;
        this.point = point;
    }

    public Studen() {

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

    public String getHometow() {
        return hometow;
    }

    public void setHometow(String hometow) {
        this.hometow = hometow;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }


}
