package com.example.demoproject.AboutYourMedicine;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demoproject.R;

import java.util.ArrayList;

public class MyListView extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<MedList> myMedList;


    public MyListView(Activity activity,ArrayList<MedList> myMedList) {
        this.myMedList = myMedList;
        this.activity = activity;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return myMedList.size();
    }

    @Override
    public MedList getItem(int position) {
        return myMedList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myMedList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        v = inflater.inflate(R.layout.my_list_layout,null);
        TextView textView = (TextView)v.findViewById(R.id.listview_text);
        MedList todoList = myMedList.get(position);
        textView.setText(todoList.getMedNameText());



        return v;
    }

}