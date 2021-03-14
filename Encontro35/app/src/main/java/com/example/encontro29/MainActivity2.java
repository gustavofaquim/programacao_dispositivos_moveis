package com.example.encontro29;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ArrayList<Item> listaDados;
    RecyclerView recycle;
    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;
    ItemRepositorio itemRepositorio;

    @SuppressLint("WrongConstant")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recycle = findViewById(R.id.Recycler);
        recycle.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        listaDados = new ArrayList<Item>();
        criarConexao();
        listaDados = itemRepositorio.buscarTodos();
        if(listaDados != null){
          AdapterDados adapter = new AdapterDados((listaDados));
          recycle.setAdapter(adapter);
        }
    }

    private void criarConexao(){
        try{
           dadosOpenHelper = new DadosOpenHelper(this);
           conexao = dadosOpenHelper.getWritableDatabase();
           itemRepositorio = new ItemRepositorio(conexao);
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(), "Deu probelma em conectar!", Toast.LENGTH_SHORT).show();
        }
    }
}