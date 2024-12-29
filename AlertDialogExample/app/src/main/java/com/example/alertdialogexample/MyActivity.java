package com.example.alertdialogexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MyActivity extends Activity {
    Button btnQuit, btnCalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        btnQuit = findViewById(R.id.btnQuit);
        btnCalculator = findViewById(R.id.btnCalculator);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMyDialog();
            }
        });
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowCustomDialog();
            }
        });
    }
    protected void ShowCustomDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
        builder.setTitle("Confirm Quit!");
        builder.setCancelable(true);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.my_calculator, null);
        Button btnCancel = v.findViewById(R.id.btnCancel);
        Button btnAdd  =v.findViewById(R.id.btnAdd);
        EditText editTextFirstNum = v.findViewById(R.id.editTextFirstNum);
        EditText editTextSecondNum = v.findViewById(R.id.editTextSecondNum);
        TextView txtResult = v.findViewById(R.id.txtResult);

        builder.setView(v);
        AlertDialog dialog = builder.create();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float n1 = Float.parseFloat(editTextFirstNum.getText().toString());
                float n2 = Float.parseFloat(editTextSecondNum.getText().toString());
                float sum = n1+n2;
                txtResult.setText(String.valueOf(sum));
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
    protected void ShowMyDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
        builder.setTitle("Confirm Quit!");
        builder.setMessage("Are you sure to quit this application?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
