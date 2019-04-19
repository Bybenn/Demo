package com.example.demoproject.AllMedicine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.demoproject.AboutYourMedicine.MedList;
import com.example.demoproject.AboutYourMedicine.MedListDAO;
import com.example.demoproject.Alarm.SetTimeActivity;
import com.example.demoproject.R;
import com.example.demoproject.User.HomeActivity;

public class ViewAllMedActivity extends AppCompatActivity {
    Button getAlertButton;
    Button noAlertButton;
    TextView nameMed;
    TextView infoMed;
    TextView useMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_med);
        nameMed = (TextView)findViewById(R.id.nameMed);
        infoMed = (TextView)findViewById(R.id.infoMed);
        useMed = (TextView)findViewById(R.id.useMed);

        getAlertButton = (Button)findViewById(R.id.getAlertButton);
        noAlertButton = (Button)findViewById(R.id.noAlertButton);


        Intent getIntent = getIntent();
        String title = getIntent.getStringExtra("title");
        String title2 = getIntent.getStringExtra("title2");
        String title3 = getIntent.getStringExtra("title3");


        nameMed.setText(title);
        infoMed.setText(title2);
        useMed.setText(title3);

        getAlertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(getApplicationContext(), SetTimeActivity.class);
                MedList medList = new MedList();
                medList.setMedNameText(String.valueOf(nameMed.getText()));
                medList.setMedInfo(String.valueOf(infoMed.getText()));


                MedListDAO medListDAO = new MedListDAO(getApplicationContext());
                medListDAO.open();
                medListDAO.add(medList);
                medListDAO.close();
                finish();
                startActivity(editIntent);
            }
        });

        noAlertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(editIntent);
            }
        });
    }
    
}
