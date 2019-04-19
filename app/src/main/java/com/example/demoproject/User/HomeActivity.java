package com.example.demoproject.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.demoproject.AboutYourMedicine.YouMedActivity;
import com.example.demoproject.AllMedicine.AllMedActivity;
import com.example.demoproject.R;

public class HomeActivity extends AppCompatActivity {

    ImageView viewAllMed;
    ImageView viewYourMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewAllMed = (ImageView) findViewById(R.id.viewAllMed);
        viewYourMed = (ImageView) findViewById(R.id.viewYourMed);

        viewAllMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(getApplicationContext(), AllMedActivity.class);
                startActivity(editIntent);
            }
        });

        viewYourMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(getApplicationContext(), YouMedActivity.class);
                startActivity(editIntent);
            }
        });

    }
}
