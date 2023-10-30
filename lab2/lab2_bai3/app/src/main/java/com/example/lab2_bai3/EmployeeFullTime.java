package com.example.lab2_bai3;

public class EmployeeFullTime extends Employee {
    public double tinhLuong() {return 500;}
    @Override
    public String toString() {
        return  super.toString() +"--"+"->FullTime="+tinhLuong();
    }
}