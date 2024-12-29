package com.example.multipleactivityexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
    TextView txtResult;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.second_activity);
        txtResult = findViewById(R.id.txtResult);
        Intent i = getIntent();
        String name = i.getStringExtra("loginName");
        String pass = i.getStringExtra("loginPassword");
        txtResult.setText("Hello "+ name + " Your password is: "+pass);
    }
}
