package com.example.eda;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class reg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);

    }

    public void backhi(View view) {
        Intent intent = new Intent(reg.this,obs1.class);
        reg.this.startActivity(intent);
    }

    public void mainreg(View view) {
        EditText milo = findViewById(R.id.mail);
        EditText pass = findViewById(R.id.pass);
        EditText name = findViewById(R.id.name);
        EditText phone = findViewById(R.id.phone);
        String aa ="1234567890qwertyuiopasdfghjklzxcvbnm";
        String bb = "qwertyuiopasdfghjklzxcvbnm";
        int a=0,b=0;
        int d =0;
        for(char zxc:milo.getText().toString().toCharArray()){
            if(zxc=='@'){
                a++;
            }
            if(zxc=='.'){
                b++;
            }
        }
        if(!milo.getText().toString().isEmpty() && !pass.getText().toString().isEmpty() && !name.getText().toString().isEmpty() && !phone.getText().toString().isEmpty()){
            if( a==1 && b==1){
                try {
                    for (char zxc:milo.getText().toString().split("@")[0].toCharArray()) {
                        if (aa.indexOf(zxc) == -1) {
                            a++;
                        }
                    }
                        for (char cxz:milo.getText().toString().split("@")[1].split("\\.")[0].toCharArray()){
                            if(aa.indexOf(cxz)==-1){
                                a++;
                            }
                        }
                    for (char cxz:milo.getText().toString().split("@")[1].split("\\.")[1].toCharArray()){
                        if(bb.indexOf(cxz)==-1){
                            a++;
                        }
                    }
                    if (milo.getText().toString().split("@")[1].split("\\.")[1].length()>3){
                        a++;
                    }
                } catch (Exception e){
                    d++;
                }
                if(d==0){
                    if(a==1){
                            String mail = milo.getText().toString();
                            String pas = pass.getText().toString();
                            String nam = name.getText().toString().split(" ")[0];
                            String url ="https://food.madskill.ru/auth/register";
                        RequestQueue requestQueue = Volley.newRequestQueue(this);
                        StringRequest stringRequest = new StringRequest(Request.Method.POST,url,response -> {
                            Intent intent = new Intent(reg.this,MainActivity.class);
                            reg.this.startActivity(intent);}, error -> {AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setTitle("Не удалось создать аккаунт.")
                                    .setMessage("Ошибка на сервере.")
                                    .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });
                            builder.show();
                        }){     @Override
                                protected Map<String, String> getParams(){
                                    Map<String,String> param = new HashMap<String, String>();
                                    param.put("email",mail);
                                    param.put("password",pas);
                                    param.put("login",nam);
                                    return param;
                             }
                        };

                        requestQueue.add(stringRequest);

                    } else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("Не удалось создать аккаунт.")
                                .setMessage("E-mail не соответствует паттерну \"name@domenname.ru\".")
                                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });
                        builder.show();
                    }
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Не удалось создать аккаунт.")
                            .setMessage("E-mail не соответствует паттерну \"name@domenname.ru\".")
                            .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                    builder.show();
                }
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Не удалось создать аккаунт.")
                        .setMessage("E-mail не соответствует паттерну \"name@domenname.ru\".")
                        .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                builder.show();
            }
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Не удалось создать аккаунт.")
                    .setMessage("Заполните все поля ввода.")
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