package com.example.recyclerwithapiexample;

import android.content.Context;
import android.util.Log;
import android.view.PixelCopy;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataLayer {
    Context context;
    public DataLayer(Context contex){
        this.context=contex;
    }
    public ArrayList<Contact> getData(){
        ArrayList<Contact> list = new ArrayList<Contact>();
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "http://10.0.2.2:2000/getContact", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0; i< response.length(); i++){
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        Log.d("object", obj.toString());
                        Contact c = new Contact();
                        c.setId(obj.getInt("id"));
                        c.setName(obj.getString("name"));
                        c.setPhone(obj.getString("phone"));
                        list.add(c);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }


                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        return list;

    }


}
