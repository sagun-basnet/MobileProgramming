package com.example.appwithdatabase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyActivity extends Activity {
    Button btnLoad;
    TextView txtResult;
    ArrayList<Person> list;
    MyDbHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        btnLoad=findViewById(R.id.btnLoad);
        txtResult = findViewById(R.id.txtResult);
        dbHelper=new MyDbHelper(this);
//        Person p = new Person();
//        p.Name="Tirtha";
//        p.Description="what is up?";
//        dbHelper.insertData(p);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
    }
    public void loadData(){
        list=dbHelper.getPersons();
        for (Person p:
            list ) {
            txtResult.setText(txtResult.getText().toString()+"\nId: "+ p.Name);
        }
    }
}
