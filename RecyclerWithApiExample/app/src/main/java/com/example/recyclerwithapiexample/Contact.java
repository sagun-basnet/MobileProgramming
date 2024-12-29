package com.example.recyclerwithapiexample;

import android.content.ComponentName;

public class Contact {
    private int Id;
    private String Name;
    private String Phone;
    public Contact(){
        Id = 0;
        Name = "";
        Phone = "";
    }
    public Contact(int Id, String Name, String Phone){
        this.Id = Id;
        this.Phone = Phone;
        this.Name = Name;
    }
    public  int getId(){
        return Id;
    }
    public void setId(int Id){
        this.Id = Id;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getPhone(){
        return Phone;
    }
    public void  setPhone(String Phone){
        this.Phone = Phone;
    }
}
