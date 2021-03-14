package com.example.encontro29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;
    ItemRepositorio itemRepositorio;

    private Item item;
    private Button botaoGravar, botaoImprimir,botaoCalcular;
    private EditText edtNome, edtCpf, edtSalarioBruto, edtDesconto;
    private FloatingActionButton botaoEditar, botaoNovo, botaoExcluir;
    private TextView visorSalario, visorInfo;
    private Boolean atualizando = false;
    private Boolean calcular = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoGravar = findViewById(R.id.btnGravar);
        botaoImprimir = findViewById(R.id.btnImprimir);
        edtNome = findViewById(R.id.editTextNome);
        edtCpf = findViewById(R.id.editTextCPF);
        edtSalarioBruto = findViewById(R.id.editTextSalarioBruto);
        edtDesconto = findViewById(R.id.editTextDesconto);
        botaoEditar = findViewById(R.id.fabEditar);
        botaoNovo = findViewById(R.id.fabNovo);
        botaoExcluir = findViewById(R.id.fabExcluir);
        botaoCalcular = findViewById(R.id.btnCalcular);
        visorSalario = findViewById(R.id.txtSalario);
        visorInfo = findViewById(R.id.txtInfo);

        //Ocultar botões
        botaoExcluir.hide();
        botaoEditar.hide();
        botaoGravar.setEnabled(false);



        //Capturando o Intent da classe Adapter dados
        Bundle oBundle = getIntent().getExtras();

        if(oBundle != null && oBundle.containsKey("DADOS")){
            //Toast.makeText(getApplicationContext(), "Tem os dados aqui em", Toast.LENGTH_SHORT).show();

            item = (Item) oBundle.getSerializable("DADOS");

            edtNome.setText(item.getNome());
            edtCpf.setText(item.getCpf());
            edtSalarioBruto.setText(item.getsalarioBruto().toString());
            edtDesconto.setText(item.getDesconto().toString());

            Double salario_bruto = Double.valueOf(edtSalarioBruto.getText().toString());
            Double desconto = Double.valueOf(edtDesconto.getText().toString());
            Double salario_liquido = calcularSalario(salario_bruto, desconto);

            visorSalario.setText(salario_liquido.toString());

            visorSalario.setVisibility(View.VISIBLE);
            visorInfo.setVisibility(View.VISIBLE);

            //Mostrar botões
            //botaoGravar.setEnabled(false);
            atualizando = true;
            ativarBotao(atualizando, calcular);
            botaoEditar.show();
            botaoExcluir.show();

        }



        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double salario_bruto = Double.valueOf(edtSalarioBruto.getText().toString());
                Double desconto = Double.valueOf(edtDesconto.getText().toString());
                Double salario_liquido = calcularSalario(salario_bruto, desconto);
                visorSalario.setText(salario_liquido.toString());

                visorSalario.setVisibility(View.VISIBLE);
                visorInfo.setVisibility(View.VISIBLE);
                //botaoGravar.setEnabled(true);
                calcular = true;
                ativarBotao(atualizando, calcular);
                //System.out.println(Double.valueOf(visorSalario.getText().toString()));

            }
        });


        botaoGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                criarConexao();
                item = new Item();
                item.setNome(edtNome.getText().toString());
                item.setCpf(edtCpf.getText().toString());
                item.setsalarioBruto(Double.valueOf(edtSalarioBruto.getText().toString()));
                item.setDesconto(Double.valueOf(edtDesconto.getText().toString()));
                item.setSalarioLiquido(Double.valueOf(visorSalario.getText().toString()));
                System.out.println("Chegou aquiiiii");

                itemRepositorio.inserir(item);
                Toast.makeText(getApplicationContext(), "Inclusão efetuada com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        botaoNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                item = new Item();

                limparCampos();

                //Ocultando novamente os botões
                //botaoGravar.setEnabled(false);
                atualizando = false;
                ativarBotao(atualizando, calcular);
                botaoExcluir.hide();
                botaoEditar.hide();

            }
        });

        botaoEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarConexao();

                item.setNome(edtNome.getText().toString());
                item.setCpf(edtCpf.getText().toString());
                item.setsalarioBruto(Double.valueOf(edtSalarioBruto.getText().toString()));
                item.setDesconto(Double.valueOf(edtDesconto.getText().toString()));

                itemRepositorio.alterar(item);

                Toast.makeText(getApplicationContext(), "Dados alterados com sucesso!", Toast.LENGTH_SHORT).show();

            }
        });

        botaoExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarConexao();

                itemRepositorio.excluir(item.getCodigo());

                Toast.makeText(getApplicationContext(), "Dado excluido com sucesso!", Toast.LENGTH_SHORT).show();
                limparCampos();

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

    public void limparCampos(){
        edtNome.setText("");
        edtCpf.setText("");
        edtDesconto.setText("");
        edtSalarioBruto.setText("");
        visorSalario.setText("");
        visorSalario.setVisibility(View.INVISIBLE);
        visorInfo.setVisibility(View.INVISIBLE);

    }

    public Double calcularSalario(Double salario_bruto, Double desconto){
        Double salario_liquido =  salario_bruto - (salario_bruto * (desconto / 100));
        return salario_liquido;
    }

    public void ativarBotao(Boolean att, Boolean calc){
        if(att == true || calc == false){
            botaoGravar.setEnabled(false);
        }
        else{
            botaoGravar.setEnabled(true);
        }

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