package com.example.gridviewexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GridViewActivity extends Activity {
    GridView myGridView;
    Button btnAdd;
    ArrayList<String> names=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity_layout);
        myGridView = findViewById(R.id.myGridView);
        btnAdd = findViewById(R.id.btnAdd);
        names.add("Roshan");
        names.add("Kiran");
        names.add("Subash");
        names.add("Puja");
        names.add("Pujan");
        names.add("Sagar");
        names.add("Budan");
        names.add("Pudan");
        adapter = new ArrayAdapter<>(this,R.layout.grid_item_layout,R.id.txtName,names);
        myGridView.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialogBox();
            }
        });

    }

    public void myDialogBox(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Input Box");
        builder.setCancelable(true);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.input_dialog_layout, null,false);
        EditText editName = v.findViewById(R.id.editName);
        Button btnSubmit = v.findViewById(R.id.btnSubmit);
        builder.setView(v);
        AlertDialog dlg = builder.create();
        dlg.show();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                names.add(editName.getText().toString());
                editName.setText("");
                adapter.notifyDataSetChanged();
                dlg.cancel();
            }
        });
    }
}
