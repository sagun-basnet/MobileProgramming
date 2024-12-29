package com.example.friendlistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Friend> {
    Context context;
    ArrayList<Friend> list;
    public MyAdapter(@NonNull Context context, @NonNull ArrayList<Friend> objects){
        super(context, R.layout.list_row_style, objects);
        this.context = context;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if(convertView==null)
            convertView=inflater.inflate(R.layout.list_row_style,parent,false);
        TextView txtName, txtAddress, txtPhone;
        Button btnEdit, btnDelete;
        txtName=convertView.findViewById(R.id.txtName);
        txtAddress=convertView.findViewById(R.id.txtAddress);
        txtPhone=convertView.findViewById(R.id.txtPhone);
        btnEdit=convertView.findViewById(R.id.btnEdit);
        btnDelete=convertView.findViewById(R.id.btnDelete);
        Friend f = getItem(position);
        txtName.setText(f.Name);
        txtAddress.setText(f.Address);
        txtPhone.setText(f.Phone);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FriendList fList = (FriendList)context;
                fList.showPromptDialog(position);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                FriendList fList = (FriendList)context;
                fList.myAdapter.notifyDataSetChanged();
            }
        });
        return convertView;
    }
}
