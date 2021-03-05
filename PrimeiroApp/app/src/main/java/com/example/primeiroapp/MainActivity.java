package com.example.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button botao,botaoNovaActivity;
    private TextView textoCentro;
    private EditText caixaTexto;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botao = findViewById(R.id.btn1);
        botaoNovaActivity = findViewById(R.id.btnNovaActivity);


        textoCentro = findViewById(R.id.txtView1);
        caixaTexto = findViewById(R.id.editText1);

        botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                textoCentro.setText(caixaTexto.getText());
            }
        });

         botaoNovaActivity.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Intent it = new Intent(MainActivity.this, MainActivity2.class);
               startActivity(it);
           }
        });


    }




}