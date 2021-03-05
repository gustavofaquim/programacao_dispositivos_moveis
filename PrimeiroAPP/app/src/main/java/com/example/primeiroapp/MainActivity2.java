package com.example.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView texto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        texto2 = findViewById(R.id.txtTexto2);

        Intent itent = getIntent();
        Bundle extras = itent.getExtras();
        String texto = extras.getString("TEXTO");
        texto2.setText(texto);


    }
}