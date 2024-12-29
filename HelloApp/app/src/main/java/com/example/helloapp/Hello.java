package com.example.helloapp;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

public class Hello extends Activity {
    //    @Nullable
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);
    }
}
