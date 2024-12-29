package com.example.activitylifecycle;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLifeCycle extends AppCompatActivity {
    Button btnQuit;
    @Override
    protected  void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_lifecycle);
        btnQuit=findViewById(R.id.button);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
        Log.v("myTest","Activity created");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v("myTest","Activity started");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.v("myTest","Activity Pause");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.v("myTest","Activity Resume");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.v("myTest","Activity Restarted");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v("myTest","Activity Destroy");
    }
}
