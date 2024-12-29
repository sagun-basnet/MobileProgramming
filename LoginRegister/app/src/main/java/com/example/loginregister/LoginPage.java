package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {
    Button btnLogin;
    EditText editName, editPass;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity3);
        btnLogin = findViewById(R.id.btnLogin);
        editName = findViewById(R.id.editName);
        editPass = findViewById(R.id.editPass);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editName.getText().toString();

                Intent i = new Intent();
                i.putExtra("username", username);

                setResult(1001,i);

                finish();
            }
        });
    }
}
