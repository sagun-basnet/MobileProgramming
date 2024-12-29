package com.example.listwithfragment;

public class Student {
    private int Roll;
    private String Name;
    private String Address;
    public Student(int roll, String name, String address){
        this.Address = address;
        this.Name=name;
        this.Roll=roll;
    }
    public int getRollNo() {
        return Roll;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }
}
