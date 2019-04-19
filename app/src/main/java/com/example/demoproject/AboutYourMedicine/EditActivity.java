package com.example.demoproject.AboutYourMedicine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.demoproject.R;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        //        รับค่า
        final MedList editMedList = (MedList) getIntent().getSerializableExtra("editMedList");


        final EditText editText = (EditText)findViewById(R.id.edit_editText);
        final EditText editText2 = (EditText)findViewById(R.id.edit_editText2);

        editText.setText(editMedList.getMedNameText());
        editText2.setText(editMedList.getMedInfo());


        Button editButton = (Button)findViewById(R.id.edit_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MedList eMedList = new MedList();
                eMedList.setId(editMedList.getId());
                eMedList.setMedNameText(String.valueOf(editText.getText()));
                eMedList.setMedInfo(String.valueOf(editText2.getText()));


//                เพื่ออัพเดท

                MedListDAO medListDAO = new MedListDAO(getApplicationContext());
                medListDAO.open();
                medListDAO.update(eMedList);
                medListDAO.close();
//                กดแล้วหายไปเลย
                finish();
            }
        });

        Button delBtn = (Button) findViewById(R.id.delete_btn);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MedListDAO medListDAODel = new MedListDAO(getApplicationContext());
                medListDAODel.open();
                medListDAODel.delete(editMedList);
                medListDAODel.close();
                finish();
            }
        });
    }
}
