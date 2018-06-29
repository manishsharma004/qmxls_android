package com.example.niu.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.niu.myapplication.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        View view = new View(this);


    }
}
