package com.example.contactapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainPage extends Activity {
    Button btnAdd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }
    protected void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Student Registration!");
        LayoutInflater inflater = getLayoutInflater();
        View v= inflater.inflate(R.layout.dialog_layout,null, false);
        EditText editName = v.findViewById(R.id.editName);
        EditText editPhone = v.findViewById(R.id.editPhone);
        Button btnPost = v.findViewById(R.id.btnPost);
        Button btnCancel = v.findViewById(R.id.btnCancel);
        builder.setView(v);
        AlertDialog dlg=builder.create();
        dlg.show();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.cancel();
            }
        });
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact c = new Contact();
                c.Id = 0;
                c.Name = editName.getText().toString();
                c.Phone = editPhone.getText().toString();
                JSONObject obj = new JSONObject();
                try {
                    obj.put("id",c.Id);
                    obj.put("name", c.Name);
                    obj.put("phone", c.Phone);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                RequestQueue queue = Volley.newRequestQueue(MainPage.this);
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://192.168.18.4:2000/postContact", obj, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainPage.this, "Contact registration sucessfull", Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainPage.this, "Contact registration failed: "+error.getMessage(), Toast.LENGTH_LONG).show();
                        Log.d("ApiError", error.getMessage());
                    }
                });
                queue.add(request);
            }
        });
    }
}






