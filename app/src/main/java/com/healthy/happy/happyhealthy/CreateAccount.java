package com.healthy.happy.happyhealthy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.Calendar;

public class CreateAccount extends AppCompatActivity implements View.OnClickListener {

    private EditText etfullname,etemail,etpass,etpassAgain,etbirthday;
    private RadioGroup genderRadioGroup;
    private Button createButton;
    private DatePickerDialog datePickerDialog;
    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        etfullname = findViewById(R.id.fullname);
        etemail = findViewById(R.id.email);
        etpass = findViewById(R.id.password);
        etpassAgain = findViewById(R.id.password_again);
        etbirthday = findViewById(R.id.birthday);
        genderRadioGroup = findViewById(R.id.gender_radiogroup);
        createButton = findViewById(R.id.create_button);

        etbirthday.setOnClickListener(this);
        createButton.setOnClickListener(this);

        Calendar calendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                etbirthday.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                datePickerDialog.dismiss();
            }
        }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
    }

    public void Back(View v)  {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.birthday){
                datePickerDialog.show();
        }
    }
}
