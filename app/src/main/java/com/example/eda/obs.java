package com.example.eda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class obs extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboardingscreen);
    }
    public void next(View view) {
        Intent intent = new Intent(obs.this,obs1.class);
        obs.this.startActivity(intent);
    }

}