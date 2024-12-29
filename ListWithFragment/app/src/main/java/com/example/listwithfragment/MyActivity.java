package com.example.listwithfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class MyActivity extends FragmentActivity {
    ArrayList<Student> students= new ArrayList<Student>();
    FrameLayout myFrame;
    ListView myListView;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle bun){
        super.onCreate(bun);
        setContentView(R.layout.myactivity_layout);
        myFrame = findViewById(R.id.myFrame);
        myListView = findViewById(R.id.myListView);
        students.add(new Student(101, "John Doe", "123 Street Name, City"));
        students.add(new Student(102, "Jane Smith", "456 Street Name, City"));
        students.add(new Student(103, "Bob Johnson", "789 Street Name, City"));
        listAdapter = new ListAdapter(this,students);
        myListView.setAdapter(listAdapter);

        myListView.setOnItemClickListener((parent, view, position, id) -> {

                Student selectedStudent = students.get(position);

                Fragment fragment = new StudentDetailFragment();
                Bundle b = new Bundle();
                b.putInt("roll", selectedStudent.getRollNo());
                b.putString("name", selectedStudent.getName());
                b.putString("address", selectedStudent.getAddress());
                fragment.setArguments(b);

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction tran = manager.beginTransaction();
                tran.replace(R.id.myFrame,fragment);
                tran.commit();

        });
    }

}
