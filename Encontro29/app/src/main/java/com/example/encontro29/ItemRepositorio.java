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
        contentValues.put("ENDERECO", item.endereco);
        contentValues.put("EMAIL", item.email);
        contentValues.put("TELEFONE", item.fone);
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
        contentValues.put("ENDERECO", item.endereco);
        contentValues.put("EMAIL", item.email);
        contentValues.put("TELEFONE", item.fone);

        String[] parametros = new String[1];
        parametros[0] = String.valueOf(item.codigo);

        conexao.update("ITEM", contentValues, "CODIGO = ?", parametros);
    }

    public ArrayList<Item> buscarTodos(){
        ArrayList<Item> itens = new ArrayList<Item>();
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT CODIGO, NOME, ENDERECO, EMAIL, TELEFONE ");
        sql.append( "FROM ITEM");

        Cursor resultado = conexao.rawQuery(sql.toString(), null);

        Item item = new Item();

        if(resultado.getCount() > 0){
            resultado.moveToFirst();

            do {
                item = new Item();

                item.codigo = resultado.getInt(resultado.getColumnIndexOrThrow("CODIGO"));
                item.nome = resultado.getString(resultado.getColumnIndexOrThrow("NOME"));
                item.endereco = resultado.getString(resultado.getColumnIndexOrThrow("ENDERECO"));
                item.email = resultado.getString(resultado.getColumnIndexOrThrow("EMAIL"));
                item.fone = resultado.getString(resultado.getColumnIndexOrThrow("TELEFONE"));

                itens.add(item);
            }while(resultado.moveToNext());

            return itens;
        }

        return null;
    }

}
