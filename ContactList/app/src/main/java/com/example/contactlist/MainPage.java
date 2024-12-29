package com.example.contactlist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MainPage extends Activity {
    ListView lstContact;
    Button btnNew;
    ArrayList<Person> personList=new ArrayList<Person>();
    CustomAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        lstContact=findViewById(R.id.lstContact);
        btnNew=findViewById(R.id.btnNew);
        personList.add(new Person("Ramesh","Dharan","9812332145"));
        personList.add(new Person("Rama","Dhangadi","9812398745"));
        adapter= new CustomAdapter(this,personList);
        lstContact.setAdapter(adapter);

    }
    public void RemoveItem(int position){
        personList.remove(position);
        adapter.notifyDataSetChanged();
    }
}
