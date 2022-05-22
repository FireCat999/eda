package com.example.eda;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class obs1 extends AppCompatActivity {
    public int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ConnectivityManager connectivityManager = (ConnectivityManager) obs1.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null && networkInfo.isConnectedOrConnecting()) {
            a++;
            super.onCreate(savedInstanceState);
            setContentView(R.layout.onboardingscreen2);
        } else{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.onboardongscreen21);
        }
    }

    public void back(View view) {
        Intent intent = new Intent(obs1.this,obs.class);
        obs1.this.startActivity(intent);
    }

    public void reg(View view) {
        if (a>0){
            Intent intent = new Intent(obs1.this,reg.class);
            obs1.this.startActivity(intent);
        }
    }

    public void log(View view) {
        if (a>0){
            Intent intent = new Intent(obs1.this,vhod.class);
            obs1.this.startActivity(intent);
        }
    }

    public void skip(View view) {
        if (a==0){
            Intent intent = new Intent(obs1.this,MainActivity.class);
            obs1.this.startActivity(intent);
        }
    }
}
