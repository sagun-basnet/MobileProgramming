package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FirstActivity extends Activity {
    Button btnNew;
    TextView txtResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        btnNew=findViewById(R.id.btnNew);
        txtResult = findViewById(R.id.txtResult);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivities(i);
                startActivityForResult(i,101);

            }
        });
    }

    //showing result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101){
            String name = data.getStringExtra("Name");
            String pass = data.getStringExtra("Password");
            String phone = data.getStringExtra("Phone");

            String result = txtResult.getText().toString()+("Result from Second Activity\n"+"Name: "+name+"\nPassword: "+pass+"\nPhone: "+phone);
            txtResult.setText(result);
        }
    }
}