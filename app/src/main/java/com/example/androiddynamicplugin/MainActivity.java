package com.example.androiddynamicplugin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ancliveplugin.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DynamicLoader.dynamicInit(this,new byte[1024]);
    }
}