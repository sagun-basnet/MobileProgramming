package com.example.contactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Person> {
    List<Person> list;
    Context context;
    public CustomAdapter(@NonNull Context context, List<Person> list){
        super(context,R.layout.list_item_layout,list);
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        if (convertView==null)
                convertView=inflater.inflate(R.layout.list_item_layout,parent,false);
        TextView txtName = convertView.findViewById(R.id.textName);
        TextView txtAddress = convertView.findViewById(R.id.textAddress);
        TextView txtPhone = convertView.findViewById(R.id.textPhone);
        Button btnEdit = convertView.findViewById(R.id.btnEdit);
        Button btnDelete = convertView.findViewById(R.id.btnDelete);
        Person p = (Person) getItem(position);
        txtName.setText(p.Name);
        txtAddress.setText(p.Address);
        txtPhone.setText(p.Phone);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainPage page = (MainPage)context;
                page.RemoveItem(position);
                Toast.makeText(context, "Remove me 😂😂?", Toast.LENGTH_LONG).show();
//                list.remove(position);
//                this.notify();
            }
        });

        return convertView;
    }
}
