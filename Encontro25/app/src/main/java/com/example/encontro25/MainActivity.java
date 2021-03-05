package com.example.encontro25;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> listaDados;
    RecyclerView recycle;

    @SuppressLint("Wrongonstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle = findViewById(R.id.ExemploRecycler);
        recycle.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));

        listaDados = new ArrayList<Item>();

        listaDados.add(new Item ("Texto Facebook", R.drawable.facebook));
        listaDados.add(new Item ("Texto Google Plus", R.drawable.googleplus));
        listaDados.add(new Item ("Texto WhatsApp", R.drawable.whatsapp));
        listaDados.add(new Item ("Texto Instagram", R.drawable.instagram));
        listaDados.add(new Item ("Texto Youtube", R.drawable.youtube));

        AdapterDados adapter = new AdapterDados(listaDados);
        recycle.setAdapter(adapter);


    }
}