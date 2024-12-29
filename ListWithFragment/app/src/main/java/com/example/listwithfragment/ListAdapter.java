package com.example.listwithfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Student> {
    Context context;
    ArrayList<Student> students;

    public ListAdapter(Context context, ArrayList<Student> students){
        super(context, R.layout.list_item_layout, students);
        this.context = context;
        this.students = students;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        if(v==null){
            v= inflater.inflate(R.layout.list_item_layout,parent, false);
        }
        TextView txtName;
        txtName = v.findViewById(R.id.txtName);
        Student s = getItem(position);
        txtName.setText(s.getName());

        return v;
    }
 }
