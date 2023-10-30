package com.example.lab2_bai3;

public abstract class Employee {
    private String id, name;
    public String getId(){return id;}
    public String getName(){return name;}
    public void setId(String id){this.id = id ;}
    public void setName(String name){
        this.name = name ;
    }

    public abstract double tinhLuong();
    public String toString(){return this.id+" - "+this.name;}
}
