package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {
    TextView txtResult;
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity1);

        txtResult = findViewById(R.id.txtResult);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId()==R.id.menuRegister){
            Intent i = new Intent(this, RegisterPage.class);
            startActivityForResult(i, 1002);
        }
        else if (item.getItemId()==R.id.menuLogin){
            Intent i = new Intent(this, LoginPage.class);
            startActivityForResult(i, 1001);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==1001){
            String username = data.getStringExtra("username");
            txtResult.setText("You are logged in as: "+ username);
        }
        else if (requestCode==1002){
//            txtResult.getText().append("You are Register.");
        }
    }
}
