package com.example.recyclerwithapiexample;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{
    TextView txtId,txtName,txtPhone;
    Button btnEdit,btnDelete;
    public MyViewHolder(@NonNull View v) {
        super(v);
        txtId = v.findViewById(R.id.txtId);
        txtName = v.findViewById(R.id.txtName);
        txtPhone = v.findViewById(R.id.txtPhone);

    }
}
