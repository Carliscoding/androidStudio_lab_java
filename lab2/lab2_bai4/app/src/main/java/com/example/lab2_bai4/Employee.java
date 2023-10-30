package com.example.lab2_bai4;

public class Employee {

    private String id;

    private String fullname;

    private boolean manager;
    public String getId(){return id;}
    public void setId(String id){this.id = id;}

    public String getFullName(){
        return fullname;
    }
    public void setFullName(String fullname){this.fullname = fullname;}
    public boolean isManager(){return manager;}
    public void setManager(boolean manager){this.manager = manager;}

}
