package com.example.fragmentwork;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainLayout extends FragmentActivity {
    Button btnHome, btnAbout, btnContact;
    FrameLayout myFrame;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        btnHome = findViewById(R.id.btnHome);
        btnAbout = findViewById(R.id.btnAbout);
        btnContact = findViewById(R.id.btnContact);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for home page
                Fragment fragment = new HomeLayout();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(R.id.myFrame, fragment);
                trans.commit();
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for About page
                Fragment fragment = new AboutLayout();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(R.id.myFrame, fragment);
                trans.commit();
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for Contact page
                Fragment fragment = new ContactLayout();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(R.id.myFrame, fragment);
                trans.commit();
            }
        });
    }
}
