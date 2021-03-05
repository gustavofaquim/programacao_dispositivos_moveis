package com.example.avaliacao01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private CheckBox checkPhp, checkPython, checkJava;
    private RadioGroup radioGroup;
    private Button btn;
    private TextView visor;
    private String linguagem, plataforma;
    private RadioButton radioButton;
    private String framework, dataMontada;
    private CalendarView calendario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkPhp = findViewById(R.id.checkPhp);
        checkPython = findViewById(R.id.checkPython);
        checkJava = findViewById(R.id.checkJava);
        radioGroup = findViewById(R.id.radioGroup);
        btn = findViewById(R.id.btn);
        visor = findViewById(R.id.visor);
        Spinner spinner = findViewById(R.id.spinner1);
        calendario = findViewById(R.id.calendario);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.frameworks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                dataMontada = dayOfMonth + "/" + (month + 1) + "/" + year;
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
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

                visor.setText("Linguagem: " + linguagem + "\n Plataforma: " + radioButton.getText() + "\n" + "Framework:" + framework + "\n" + "Data: " + dataMontada);
            }
        });

    }

    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        Toast.makeText(this, "Select Radio Button: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView txt = findViewById(R.id.frase);
        String text = parent.getItemAtPosition(position).toString();
        framework = text;
        //txt.setText("");
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}