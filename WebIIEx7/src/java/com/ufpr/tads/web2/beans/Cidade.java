/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

/**
 *
 * @author Tiago
 */
public class Cidade {
    private int id_cidade;
    private String nome_cidade;

    public Cidade() {
    }

    public Cidade(int id_cidade, String nome_cidade) {
        this.id_cidade = id_cidade;
        this.nome_cidade = nome_cidade;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getNome_cidade() {
        return nome_cidade;
    }

    public void setNome_cidade(String nome_cidade) {
        this.nome_cidade = nome_cidade;
    }
}
