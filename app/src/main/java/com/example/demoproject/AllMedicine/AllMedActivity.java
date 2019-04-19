package com.example.demoproject.AllMedicine;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.demoproject.DatabaseHelper;
import com.example.demoproject.R;

import java.util.ArrayList;

public class AllMedActivity extends AppCompatActivity {
    DatabaseHelper db;

//    Button add_data;
//    EditText add_name;

    ListView userlist;

    ArrayList<String> listItem;
    ArrayList<String> listItem2;
    ArrayList<String> listItem3;

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_med);
        db = new DatabaseHelper(this);

        listItem = new ArrayList<>();
        listItem2 = new ArrayList<>();
        listItem3 = new ArrayList<>();


//        add_data = findViewById(R.id.add_data);
//        add_name = findViewById(R.id.add_name);
        userlist = findViewById(R.id.users_list);


        viewData();

        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = userlist.getItemAtPosition(position).toString();

//                String text2 = listItem2.get(position).toString();
                String text3 = listItem3.get(position).toString();
                String text2 = listItem2.get(position).toString();




                Toast.makeText(AllMedActivity.this,""+text,Toast.LENGTH_SHORT).show();
                Intent editIntent = new Intent(getApplicationContext(),ViewAllMedActivity.class);
                editIntent.putExtra("title",text);
//                editIntent.putExtra("title1",text2);
                editIntent.putExtra("title2",text3);
                editIntent.putExtra("title3",text2);

                startActivity(editIntent);
            }
        });
    }

    private void viewData() {
        Cursor cursor = db.viewData();
        if (cursor.getCount()==0){
            Toast.makeText(this,"No data to show", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                listItem.add(cursor.getString(1));
                listItem3.add(cursor.getString(2));
                listItem2.add(cursor.getString(3));



            }

            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listItem);
            userlist.setAdapter(adapter);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.item_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> userslist = new ArrayList<>();

                for (String user : listItem){
                    if (user.toLowerCase().contains(newText.toLowerCase())){
                        userslist.add(user);
                    }
                }
                ArrayAdapter adapter = new ArrayAdapter<String>(AllMedActivity.this,
                        android.R.layout.simple_list_item_1, userslist);
                userlist.setAdapter(adapter);


                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

}
