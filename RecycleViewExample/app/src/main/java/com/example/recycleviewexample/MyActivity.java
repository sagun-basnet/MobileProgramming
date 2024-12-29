package com.example.recycleviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyActivity extends Activity {
    Button btnAdd;
    ArrayList<Person> list = new ArrayList<Person>();
    RecyclerView myRecycler;
    RecyclerView.LayoutManager manager;
    MyAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_layout);
        myRecycler=findViewById(R.id.myRecycle);
        list.add(new Person("Bishal", "Good Person"));
        manager=new LinearLayoutManager(this);
        myRecycler.setLayoutManager(manager);
        adapter=new MyAdapter(this,list);
        myRecycler.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
