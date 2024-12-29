package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.activitytest.R;

public class SecondActivity extends Activity {
    EditText editName, editPhone, editPass;
    Button btnSubmit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        editName = findViewById(R.id.editName);
        editPass = findViewById(R.id.editPassword);
        editPhone = findViewById(R.id.editPhone);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                i.putExtra("Name",editName.getText().toString());
                i.putExtra("Password", editPass.getText().toString());
                i.putExtra("Phone", editPhone.getText().toString());
                setResult(101,i);
                finish();
            }
        });

    }
}
