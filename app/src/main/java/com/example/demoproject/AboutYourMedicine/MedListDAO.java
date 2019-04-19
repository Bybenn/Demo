package com.example.demoproject.AboutYourMedicine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.demoproject.DatabaseHelper;

import java.util.ArrayList;

public class MedListDAO {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public MedListDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
//       เปิดเพื่อแก้ไข
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ArrayList<MedList> getAllMedList() {
        ArrayList<MedList> medList = new ArrayList<MedList>();
        Cursor cursor = database.rawQuery("SELECT * FROM you_med", null);
        cursor.moveToFirst();
        MedList medList1;
        while (!cursor.isAfterLast()) {
//            ให้ข้อมูล เซ็ทอัพเดทเป็นปัจจุบัน
            medList1 = new MedList();
            medList1.setId(cursor.getInt(0));
            medList1.setMedNameText(cursor.getString(1));
            medList1.setMedInfo(cursor.getString(2));
            medList.add(medList1);
            cursor.moveToNext();
        }
        cursor.close();
        return medList;
    }

    public void add(MedList medList) {
        MedList newMedList = new MedList();
        newMedList = medList;

        ContentValues values = new ContentValues();
        values.put("medname", newMedList.getMedNameText());
        values.put("medinfo",newMedList.getMedInfo());
        this.database.insert("you_med", null, values);

        Log.d("Todo List Demo :::", "Add OK!!!");

    }

    public void update(MedList medList) {
        MedList updateMedList = medList;
        ContentValues values = new ContentValues();
        values.put("medinfo", updateMedList.getMedInfo());
        values.put("medname", updateMedList.getMedNameText());
        values.put("id", updateMedList.getId());
        String where = "id=" + updateMedList.getId();

        this.database.update("you_med", values, where, null);
        Log.d("Todo List :::", "Update OK!!!");
    }

    public void delete(MedList medList) {
        MedList delMedList = medList;
        String sqlText = "DELETE FROM you_med WHERE id=" + delMedList.getId();
        this.database.execSQL(sqlText);
    }
}
