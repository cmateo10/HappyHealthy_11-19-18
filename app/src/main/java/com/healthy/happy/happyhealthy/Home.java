package com.healthy.happy.happyhealthy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void CalorieLog(View v)  {
        Intent i = new Intent(this, DailyCalorieLog.class);
        startActivity(i);
    }

    public void PastLogs(View v)  {
        Intent i = new Intent(this, PastLogs.class);
        startActivity(i);
    }

    public void SignOut(View v)  {
        Toast.makeText(this,"Coming Soon",Toast.LENGTH_LONG).show();
    }
}
