package com.example.encontro25;

public class Item {
    String descricao;
    int foto;

    public Item(){

    }

    public Item(String descricao, int foto){
        this.descricao = descricao;
        this.foto = foto;
    }

    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public int getFoto(){
        return foto;
    }
    public void setFoto(int foto){
        this.foto = foto;
    }


}
