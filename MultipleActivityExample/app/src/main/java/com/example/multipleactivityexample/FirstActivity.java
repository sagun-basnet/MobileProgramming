package com.example.multipleactivityexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends Activity {
    Button btnLogin;
    EditText editName, editPassword;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.first_activity);
        btnLogin=findViewById(R.id.btnLogin);
        editName=findViewById(R.id.editName);
        editPassword=findViewById(R.id.editPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FirstActivity.this, SecondActivity.class);
                i.putExtra("loginName", editName.getText().toString());
                i.putExtra("loginPassword", editPassword.getText().toString());
                startActivity(i);
            }
        });
    }
}
