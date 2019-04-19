package com.example.demoproject.AboutYourMedicine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.demoproject.R;

public class AddNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        final EditText newMedListText = (EditText) findViewById(R.id.addnew_editText);
        final EditText addInfo = (EditText) findViewById(R.id.infoText);



        Button newMedListButton = (Button) findViewById(R.id.addnew_button);
        newMedListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MedList medList = new MedList();
                medList.setMedNameText(String.valueOf(newMedListText.getText()));
                medList.setMedInfo(String.valueOf(addInfo.getText()));


                MedListDAO medListDAO = new MedListDAO(getApplicationContext());
                medListDAO.open();
                medListDAO.add(medList);
                medListDAO.close();
                finish();




            }
        });
    }
}
