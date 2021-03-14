package com.example.encontro29;

public class ScriptDDL {

    public static String getCreateTableContato(){

        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS ITEM (");
        sql.append(" CODIGO INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sql.append(" NOME VARCHAR(25) NOT NULL DEFAULT (''),");
        sql.append(" CPF VARCHAR(11) NOT NULL DEFAULT (''),");
        sql.append(" SALARIO_BRUTO REAL NOT NULL,");
        sql.append(" DESCONTO REAL NOT NULL,");
        sql.append(" SALARIO_LIQUIDO REAL NOT NULL)");

        return sql.toString();

    }
}
