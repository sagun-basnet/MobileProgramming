package com.example.loginexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginExample extends Activity {
    EditText txtLoginId, txtPassword;
    Button btnLogin;

    @Override
    protected  void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.login_page);
        txtLoginId=findViewById(R.id.editLoginId);
        txtPassword=findViewById(R.id.editLoginPassword);
        btnLogin=findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hi, "+ txtLoginId.getText().toString()+ " Your password is: "+ txtPassword.getText().toString().Toast.LENGTH_LONG).show();
            }
        });
    }
}
