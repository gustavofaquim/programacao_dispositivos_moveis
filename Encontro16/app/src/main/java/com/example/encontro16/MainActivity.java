package com.example.encontro16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button botao;
    public TextView setup,resultado;
    EditText n1;
    EditText n2;
    EditText n3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        setup = findViewById(R.id.txtView1);
        botao = findViewById(R.id.btnVerificar);
        n1 = findViewById(R.id.editText1);
        n2 = findViewById(R.id.editText2);
        n3 = findViewById(R.id.editText3);

        botao.setOnClickListener(new View.OnCligeckListener() {
            @Override
            public void onClick(View v) {
                int resultado =   menorValor(Integer.parseInt(n1.getText().toString()),Integer.parseInt(n2.getText().toString()),Integer.parseInt(n3.getText().toString()));
                setup.setText(""+resultado);
            }
        });

    }
    public int menorValor(int i,int j, int k){
        int a = i;
        int b = j;
        int c = k;
        int menor = a;
        int maior = a;
        if (b > maior) maior = b;
        if (c > maior) maior = c;
        if (b < menor) menor = b;
        if (c < menor) menor = c;

        return maior;
    }
}