package com.example.maiornumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Button btn01;
    private double resultado, num1, num2, num3;
    private TextInputEditText inputText01,inputText02,inputText03;
    private EditText textVisor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textVisor = (EditText) findViewById(R.id.textVisor);
        textVisor.setFocusable(false);
        textVisor.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btn01 = findViewById(R.id.btn01);
        inputText01 = (TextInputEditText) findViewById(R.id.inputText01);
        inputText01 = (TextInputEditText) findViewById(R.id.inputText02);
        inputText01 = (TextInputEditText) findViewById(R.id.inputText03);


        btn01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                num1 = Double.parseDouble(inputText01.getText().toString());
                num2 = Double.parseDouble(inputText02.getText().toString());
                num3 = Double.parseDouble(inputText03.getText().toString());
                System.out.println(num1);
                textVisor.setText(String.valueOf(num1));

            }
        });

    }
}