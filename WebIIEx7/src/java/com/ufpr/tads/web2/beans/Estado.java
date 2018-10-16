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
public class Estado {
    private int id_estado;
    private String nome_estado;

    public Estado() {
    }

    public Estado(int id_estado, String nome_estado) {
        this.id_estado = id_estado;
        this.nome_estado = nome_estado;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getNome_estado() {
        return nome_estado;
    }

    public void setNome_estado(String nome_cidade) {
        this.nome_estado = nome_estado;
    }
}
