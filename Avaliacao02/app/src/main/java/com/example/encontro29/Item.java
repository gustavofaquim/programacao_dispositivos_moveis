package com.example.encontro29;

import java.io.Serializable;
import java.math.BigInteger;

public class Item implements Serializable {
    int codigo;
    String nome, cpf;
    Double salarioBruto, desconto, salarioLiquido;

    public String getNome() { return nome; }

    public int getCodigo() { return codigo; }

    public Double getsalarioBruto() { return salarioBruto; }

    public Double getDesconto() { return desconto; }

    public Double getSalarioLiquido() { return salarioLiquido; }

    public String getCpf() { return cpf; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(int codigo) { this.codigo = codigo; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public void setDesconto(Double desconto) { this.desconto = desconto; }

    public void setsalarioBruto(Double salarioBruto) { this.salarioBruto = salarioBruto; }

    public void setSalarioLiquido(Double salarioLiquido) { this.salarioLiquido = salarioLiquido; }
}
