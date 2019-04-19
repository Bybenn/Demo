package com.example.demoproject.User;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.demoproject.DatabaseHelper;
import com.example.demoproject.R;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    EditText mTextMorning;
    EditText mTextAfternoon;
    EditText mTextEvening;
    Button mButtonRegister;
    TextView mTextViewLogin;
    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.edittext_username);
        mTextPassword = (EditText)findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText)findViewById(R.id.edittext_cnf_password);
        mTextMorning = (EditText)findViewById(R.id.edittext_morning);
        mTextAfternoon = (EditText)findViewById(R.id.edittext_afternoon);
        mTextEvening = (EditText)findViewById(R.id.edittext_evening);
        mButtonRegister = (Button)findViewById(R.id.button_register);
        mTextViewLogin = (TextView)findViewById(R.id.textview_login);

        mTextMorning.setOnClickListener(new View.OnClickListener() {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(RegisterActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int i, int il) {
                        String am_pm;
                        if (i<12){
                            am_pm = "AM";
                            mTextMorning.setText(i+":"+il+" "+am_pm);
                        }else if (i==12){
                            am_pm = "PM";
                            mTextMorning.setText(i+":"+il+" "+am_pm);
                        }else {
                            am_pm = "PM";
                            mTextMorning.setText(i+":"+il+" "+am_pm);
                        }
                    }
                },hour,minute,false);
                timePickerDialog.show();

            }
        });
        mTextAfternoon.setOnClickListener(new View.OnClickListener() {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(RegisterActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int i, int il) {
                        String am_pm;
                        if (i<12){
                            am_pm = "AM";
                            mTextAfternoon.setText(i+":"+il+" "+am_pm);
                        }else if (i==12){
                            am_pm = "PM";
                            mTextAfternoon.setText(i+":"+il+" "+am_pm);
                        }else {
                            am_pm = "PM";
                            mTextAfternoon.setText(i+":"+il+" "+am_pm);
                        }
                    }
                },hour,minute,false);
                timePickerDialog.show();

            }
        });
        mTextEvening.setOnClickListener(new View.OnClickListener() {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(RegisterActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int i, int il) {
                        String am_pm;
                        if (i<12){
                            am_pm = "AM";
                            mTextEvening.setText(i+":"+il+" "+am_pm);
                        }else if (i==12){
                            am_pm = "PM";
                            mTextEvening.setText(i+":"+il+" "+am_pm);
                        }else {
                            am_pm = "PM";
                            mTextEvening.setText(i+":"+il+" "+am_pm);
                        }
                    }
                },hour,minute,false);
                timePickerDialog.show();

            }
        });


        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();
                String morning = mTextMorning.getText().toString().trim();
                String afternoon = mTextAfternoon.getText().toString().trim();
                String evening = mTextEvening.getText().toString().trim();

                if(pwd.equals(cnf_pwd)){
                    long val = db.addUser(user,pwd,morning,afternoon,evening);
                    if(val > 0){
                        Toast.makeText(RegisterActivity.this,"You have registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Registeration Error",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(RegisterActivity.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
