package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    Button botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botao9,botao0, botaoIgual, botaoSoma, botaoSubtracao, botaoDivisao, botaoMultiplicacao, botaoPonto, botaoLimpar;

    private double resultado = 0;
    private EditText textVisor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textVisor = (EditText) findViewById(R.id.txtVisor);
        textVisor.setFocusable(false);
        textVisor.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        botao1 = findViewById(R.id.btn1);
        botao2 = findViewById(R.id.btn2);
        botao3 = findViewById(R.id.btn3);
        botao4 = findViewById(R.id.btn4);
        botao5 = findViewById(R.id.btn5);
        botao6 = findViewById(R.id.btn6);
        botao7 = findViewById(R.id.btn7);
        botao8 = findViewById(R.id.btn8);
        botao9 = findViewById(R.id.btn9);
        botao0 = findViewById(R.id.btn0);
        botaoSoma = findViewById(R.id.btnSoma);
        botaoIgual = findViewById(R.id.btnIgual);
        botaoLimpar = findViewById(R.id.btnLimpar);
        botaoMultiplicacao = findViewById(R.id.btnMultiplicacao);
        botaoDivisao = findViewById(R.id.btnDivisao);
        botaoSubtracao = findViewById(R.id.btnSubtracao);
        botaoPonto = findViewById(R.id.btnPonto);


        botao1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(1).toString());
            }
        });

        botao2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(2).toString());
            }
        });

        botao3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(3).toString());
            }
        });

        botao4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(4).toString());
            }
        });

        botao5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(5).toString());
            }
        });

        botao6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(6).toString());
            }
        });

        botao7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(7).toString());
            }
        });

        botao8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(8).toString());
            }
        });

        botao8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(8).toString());
            }
        });

        botao9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(9).toString());
            }
        });

        botao0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(0).toString());
            }
        });

        botaoSoma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(" + ").toString());
            }
        });

        botaoMultiplicacao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(" * ").toString());
            }
        });

        botaoDivisao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(" / ").toString());
            }
        });

        botaoSubtracao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(" - ").toString());
            }
        });

        botaoPonto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textVisor.setText(new StringBuilder().append(textVisor.getText()).append(".").toString());
            }
        });

        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resultado = 0;
                textVisor.setText("");
            }
        });

        botaoIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String shortName = "rhino";
                String  anotherString = "";
                if(textVisor.getText().toString() != null && !textVisor.getText().toString().equalsIgnoreCase(anotherString)) {
                    ScriptEngine engine = new ScriptEngineManager().getEngineByName(shortName);

                    try {
                        resultado = (double) engine.eval(textVisor.getText().toString().trim());
                        textVisor.setText(String.valueOf(resultado));
                        resultado = 0;
                    } catch (ScriptException e){
                        textVisor.setText("Erro");
                    }
                }
            }
        });




    }
}