package com.example.appwithdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper {
    public MyDbHelper(@Nullable Context context) {
        super(context, "myDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Person(Id INTEGER PRIMARY key AUTOINCREMENT, Name Text not null, Description Text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists Person");
        onCreate(db);
    }

    public boolean insertData(Person p){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name",p.Name);
        values.put("Description", p.Description);
        long count = db.insert("Person",null, values);
        return count ==1;
    }

    public ArrayList<Person> getPersons(){
        ArrayList<Person> list = new ArrayList<Person>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("Select Id,Name, Description from Person", null);
        while (cursor.moveToNext()){
            Person p = new Person();
            p.Id=cursor.getInt(0);
            p.Name=cursor.getString(1);
            p.Description = cursor.getString(2);
            list.add(p);
        }
        cursor.close();
        db.close();
        return list;
    }
    public boolean deleteData(int id){
        SQLiteDatabase db = getWritableDatabase();
        long count = db.delete("Person","id=?", new String[]{String.valueOf(id)});
        db.close();
        return count ==1;
    }

    public boolean updateData(Person p){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Name",p.Name);
        values.put("Description", p.Description);
        int id= db.update("Person",values, "Id=?", new String[]{String.valueOf(p.Id)});
        db.close();
        return id>0;
    }
}
