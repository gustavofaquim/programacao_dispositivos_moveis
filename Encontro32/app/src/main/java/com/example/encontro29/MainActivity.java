package com.example.encontro29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;
    ItemRepositorio itemRepositorio;

    private Item item;
    private Button botaoGravar, botaoImprimir;
    private EditText edtNome, edtEndereco, edtEmail, edtFone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoGravar = findViewById(R.id.btnGravar);
        botaoImprimir = findViewById(R.id.btnImprimir);
        edtNome = findViewById(R.id.editTextNome);
        edtEndereco = findViewById(R.id.editTextEndereco);
        edtEmail = findViewById(R.id.editTextEmail);
        edtFone = findViewById(R.id.editTextTelefone);

        //Capturando o Intent da classe Adapter dados
        Bundle oBundle = getIntent().getExtras();

        if(oBundle != null && oBundle.containsKey("DADOS")){
            Toast.makeText(getApplicationContext(), "Tem os dados aqui em", Toast.LENGTH_SHORT).show();
        }


        botaoGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                criarConexao();
                item = new Item();
                item.setNome(edtNome.getText().toString());
                item.setEmail(edtEmail.getText().toString());
                item.setEndereco(edtEndereco.getText().toString());
                item.setFone(edtFone.getText().toString());
                itemRepositorio.inserir(item);
                Toast.makeText(getApplicationContext(), "Inclusão efetuada com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        botaoImprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*ArrayList<Item> listaDados = new ArrayList<Item>();

                criarConexao();

                listaDados = itemRepositorio.buscarTodos();

                for(Item oItem : listaDados){
                    System.out.println("==============================");
                    System.out.println("Codigo: "+ oItem.getCodigo());
                    System.out.println("Nome: "+ oItem.getNome());
                    System.out.println("Endereco: "+ oItem.getEndereco());
                    System.out.println("Fone: "+ oItem.getFone());
                    System.out.println("Email: "+ oItem.getEmail());
                }*/
                Intent it = new Intent (MainActivity.this, MainActivity2.class);
                startActivity(it);
            }
        });

    }

    private void criarConexao(){
        try {
            dadosOpenHelper = new DadosOpenHelper(this);
            conexao = dadosOpenHelper.getWritableDatabase();
            itemRepositorio = new ItemRepositorio(conexao);
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(), "Deu ruim na conexão!", Toast.LENGTH_SHORT).show();
        }
    }
}