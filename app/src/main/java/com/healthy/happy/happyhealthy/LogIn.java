package com.healthy.happy.happyhealthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    public void Back(View v)  {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void Login(View v)  {
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }

}
