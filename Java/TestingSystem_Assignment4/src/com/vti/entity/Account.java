package com.vti.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Account {
    private long id;
    private String email;
    private String userName;
    private String fullName;
    private String lastName;
    private String firsName;
    private Position position;
    private LocalDate createDate;
    public Account(long id, String email, String lastName, String firsName) {
        this.id = id;
        this.email = email;

        this.lastName = lastName;
        this.firsName = firsName;
        this.fullName = firsName + " " + lastName;
    }


    public Account(long id, String email, String userName, String lastName,
                   String firsName, Position position) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.lastName = lastName;
        this.firsName = firsName;
        this.fullName = firsName + " " + lastName;
        this.position = position;
        this.createDate = LocalDate.from(LocalDateTime.now());

    }

    public Account(long id, String email, String userName, String lastName,
                   String firsName, Position position,LocalDate createDate) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.lastName = lastName;
        this.firsName = firsName;
        this.fullName = firsName + " " + lastName;
        this.position = position;
        this.createDate = createDate;

    }



    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }



    public Account() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }
}
