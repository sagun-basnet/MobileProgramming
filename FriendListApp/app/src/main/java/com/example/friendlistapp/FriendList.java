package com.example.friendlistapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FriendList extends Activity {
    Button btnNew;
    ArrayList<Friend> myFriends = new ArrayList<Friend>();
    MyAdapter myAdapter;
    ListView myListView;
    Friend friend;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_layout);
        myListView = findViewById(R.id.myList);
        myAdapter=new MyAdapter(this,myFriends);
        myListView.setAdapter(myAdapter);
        btnNew = findViewById(R.id.btnNew);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPromptDialog(-1);
            }
        });
    }
    public void showPromptDialog(int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if(position == -1){
            builder.setTitle("Add Friend");
        }
        else
            builder.setTitle("Edit Friend");
        builder.setCancelable(false);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.input_dialog_layout, null, false);
        EditText editName, editAddress, editPhone;
        Button btnSubmit, btnCancel;
        editName=v.findViewById(R.id.editName);
        editAddress=v.findViewById(R.id.editAddress);
        editPhone=v.findViewById(R.id.editPhone);
        if(position>=0){
            Friend editFriend=myFriends.get(position);
            editName.setText(editFriend.Name);
            editAddress.setText(editFriend.Address);
            editPhone.setText(editFriend.Phone);
        }

        btnSubmit=v.findViewById(R.id.btnSubmit);
        btnCancel=v.findViewById(R.id.btnCancel);
        builder.setView(v);
        AlertDialog dlg = builder.create();
        dlg.show();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position==-1){
                    Friend f = new Friend();
                    f.Name=editName.getText().toString();
                    f.Address=editAddress.getText().toString();
                    f.Phone=editPhone.getText().toString();
                    myFriends.add(f);
                    editName.setText("");
                    editAddress.setText("");
                    editPhone.setText("");
                    myAdapter.notifyDataSetChanged();
                }
                else {
                    myFriends.get(position).Name=editName.getText().toString();
                    myFriends.get(position).Address=editAddress.getText().toString();
                    myFriends.get(position).Phone=editPhone.getText().toString();
                    myAdapter.notifyDataSetChanged();
                    dlg.cancel();
                }



            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.cancel();
            }
        });
    }
}
