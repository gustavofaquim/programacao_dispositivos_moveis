package com.example.encontro23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendario;
    private Button btn;
    private TextView visor;
    private Integer ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendario = findViewById(R.id.calendarView);
        btn = findViewById(R.id.btn01);
        visor = findViewById(R.id.visor);



        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //String dataMontada = dayOfMonth + "/" + (month + 1) + "/" + year;
                ano = year;
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int y = idade(ano);
                System.out.println("Idade: " + y );
                visor.setText("Idade: " + y);
            }
        });


    }

    public int idade(int ano){
        Calendar c = Calendar.getInstance();
        int x = c.get(Calendar.YEAR) - ano;
        return x;
    }
}