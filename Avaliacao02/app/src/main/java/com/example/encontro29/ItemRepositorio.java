package com.example.encontro29;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ItemRepositorio {

    private SQLiteDatabase conexao;

    public ItemRepositorio(SQLiteDatabase conexao){
        this.conexao = conexao;
    }

    public void inserir(Item item){
        ContentValues contentValues = new ContentValues();

        contentValues.put("NOME", item.nome);
        contentValues.put("CPF", item.cpf);
        contentValues.put("DESCONTO", item.desconto);
        contentValues.put("SALARIO_BRUTO", item.salarioBruto);
        contentValues.put("SALARIO_LIQUIDO", item.salarioLiquido);
        conexao.insertOrThrow("ITEM", null, contentValues);
    }

    public void excluir(int codigo){
        String[] parametros = new String[1];

        parametros[0] = String.valueOf(codigo);

        conexao.delete("ITEM", "CODIGO = ?", parametros);
    }

    public void alterar(Item item){
        ContentValues contentValues = new ContentValues();

        contentValues.put("NOME", item.nome);
        contentValues.put("CPF", item.cpf);
        contentValues.put("DESCONTO", item.desconto);
        contentValues.put("SALARIO_BRUTO", item.salarioBruto);
        contentValues.put("SALARIO_LIQUIDO", item.salarioLiquido);

        String[] parametros = new String[1];
        parametros[0] = String.valueOf(item.codigo);

        conexao.update("ITEM", contentValues, "CODIGO = ?", parametros);
    }

    public ArrayList<Item> buscarTodos(){
        ArrayList<Item> itens = new ArrayList<Item>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT CODIGO, NOME, CPF, SALARIO_BRUTO, DESCONTO, SALARIO_LIQUIDO");
        sql.append(" FROM ITEM");

        Cursor resultado = conexao.rawQuery(sql.toString(), null);

        Item item = new Item();

        if(resultado.getCount() > 0){
            resultado.moveToFirst();

            do {
                item = new Item();

                item.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("CODIGO"));
                item.nome = resultado.getString(resultado.getColumnIndexOrThrow("NOME"));
                item.cpf = resultado.getString(resultado.getColumnIndexOrThrow("CPF"));
                item.salarioBruto = resultado.getDouble(resultado.getColumnIndexOrThrow("SALARIO_BRUTO"));
                item.salarioLiquido = resultado.getDouble(resultado.getColumnIndexOrThrow("SALARIO_LIQUIDO"));
                item.desconto = resultado.getDouble(resultado.getColumnIndexOrThrow("DESCONTO"));

                itens.add(item);
            }while(resultado.moveToNext());

            return itens;
        }
        return null;
    }

}
