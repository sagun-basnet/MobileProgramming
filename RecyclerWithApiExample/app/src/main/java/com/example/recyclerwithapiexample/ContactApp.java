package com.example.recyclerwithapiexample;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactApp extends Activity {
    Button btnNew;
    RecyclerView myRecycler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_layout);
        findViewById(R.id.btnNew);
        findViewById(R.id.myRecycler);
    }
    //for Load Data
    public void LoadData(){
        DataLayer ld = new DataLayer(this);
        ArrayList<Contact> list =new ArrayList<Contact>();
        MyAdapter adapter = new MyAdapter(this, list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        myRecycler.setLayoutManager(manager);
        myRecycler.setAdapter(adapter);

    }
}
