package com.example.encontro21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkPhp, checkPython, checkJava;
    private RadioGroup radioGroup;

    private Button btn01;
    private TextView visor;
    private String linguagem, plataforma;
    private RadioButton radioButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkPhp = findViewById(R.id.checkPhp);
        checkPython = findViewById(R.id.checkPython);
        checkJava = findViewById(R.id.checkJava);
        radioGroup = findViewById(R.id.radioGroup);

        btn01 = findViewById(R.id.btn01);
        visor = findViewById(R.id.visor);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linguagem = " ";
                if(checkPhp.isChecked()){
                    linguagem += "|PHP| ";
                }
                if(checkPython.isChecked()){
                    linguagem += "|Python| ";
                }
                if(checkJava.isChecked()){
                    linguagem += "|Java| ";
                }

                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                visor.setText("Linguagem: " + linguagem + "\n Plataforma: " + radioButton.getText());
               // visor.setText("Seu texto: " + radioButton.getText());
            }
        });



    }

    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        Toast.makeText(this, "Select Radio Button: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}