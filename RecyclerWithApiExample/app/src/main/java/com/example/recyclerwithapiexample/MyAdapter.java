package com.example.recyclerwithapiexample;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    ArrayList<Contact> list;
    ContactApp activity;
    public MyAdapter(ContactApp activity, ArrayList<Contact> list ){
        this.activity = activity;
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View v = inflater.inflate(R.layout.recycler_item_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contact c = list.get(position);
        holder.txtId.setText(String.valueOf(c.getId()));
        holder.txtName.setText(c.getName());
        holder.txtPhone.setText(c.getPhone());

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete code
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
