package com.example.demoproject.AboutYourMedicine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.demoproject.R;

import java.util.ArrayList;

public class YouMedActivity extends AppCompatActivity {
    ListView todoListView;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_med);
        todoListView = (ListView)findViewById(R.id.todo_listView);

        MedListDAO medListDAO = new MedListDAO(getApplicationContext());
        medListDAO.open();
        ArrayList<MedList> myList = medListDAO.getAllMedList();
        //        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,myList);
        final MyListView adapter = new MyListView(this,myList);


        todoListView.setAdapter(adapter);
        medListDAO.close();

//        ให้กดใน listView ได้

        todoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
//            คืนค่าเป็นไอดีเพื่อเอาไปแก้ไข
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),String.valueOf(adapter.getItemId(position)),
//                        Toast.LENGTH_SHORT).show();
                Intent editIntent = new Intent(getApplicationContext(),EditActivity.class);
//                editIntent.putExtra("editMedList",adapter.getItem(position));
                editIntent.putExtra("editMedList",adapter.getItem(position));
                startActivity(editIntent);
            }
        });


    }


    public void onResume() {

        super.onResume();
        MedListDAO medListDAO = new MedListDAO(getApplicationContext());
        medListDAO.open();
        ArrayList<MedList> myList = medListDAO.getAllMedList();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,myList);

        MyListView adapter = new MyListView(this,myList);
        todoListView.setAdapter(adapter);
        medListDAO.close();
    }

    public void clickImageButton(View view){
        Intent intent = new Intent(this,AddNewActivity.class);
        startActivity(intent);

    }
}
