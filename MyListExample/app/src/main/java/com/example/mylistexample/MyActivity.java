package com.example.mylistexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyActivity extends Activity {
    ListView myList;
    Button btnAdd;
    ArrayList<String> nameList = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.my_activity_layout);
        myList = findViewById(R.id.myList);
        btnAdd = findViewById(R.id.btnAdd);
//        String nameList[] = {"me","myself","i","you","him","she"};
//        nameList.add("we");
        adapter = new ArrayAdapter<String>(this,R.layout.list_item_view,R.id.txtName, nameList);
        myList.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyInputBox();
            }
        });
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String selectedName=adapter.getItem(i);
                Toast.makeText(getApplicationContext(), "Hello "+selectedName, Toast.LENGTH_LONG).show();
            }
        });
    }
    protected void showMyInputBox(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Prompt Dialog");
        builder.setCancelable(false);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.my_input_box,null);
        Button btnDismiss = findViewById(R.id.button2);
        Button btnSubmit = findViewById(R.id.button);
        EditText editName = findViewById(R.id.editName);
        builder.setView(v);
        AlertDialog dialog = builder.create();
        dialog.show();
        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = editName.getText().toString();
                nameList.add(newName);
                editName.setText("");
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Name added.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
