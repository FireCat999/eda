package com.example.eda;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }


    public void check(View view) {
        EditText telega = findViewById(R.id.adres);
        int a=0,c=0;
        for (char zxc:telega.getText().toString().toCharArray()){
            if (zxc == ','){
                a++;
            }
        }
        if(a==2){
           try {
               if (telega.getText().toString().split(",")[0].length() == 0) {

               }
               if (telega.getText().toString().split(",")[1].length() == 0) {

               }
               if (telega.getText().toString().split(",")[2].length() == 0) {

               }
           } catch (Exception e){
               c++;
           }
           if(c==0){

           }else{
               AlertDialog.Builder builder = new AlertDialog.Builder(this);
               builder.setTitle("Ошибка ввода адреса.")
                       .setMessage("Адрес не соответствует маске: Город, Улица, Дом.")
                       .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               dialogInterface.cancel();
                           }
                       });
               builder.show();
           }
        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Ошибка ввода адреса.")
                    .setMessage("Адрес не соответствует маске: Город, Улица, Дом.")
                    .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            builder.show();
        }
    }
}