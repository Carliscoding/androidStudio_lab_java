package com.example.lab2_bai3;

public class  EmployeeParttime extends Employee {

    public double tinhLuong() {return 150;}
    @Override
    public String toString() {
        return  super.toString()+ "--"+"->PartTime = "+tinhLuong();
    }
}