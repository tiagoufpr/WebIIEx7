/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;

/**
 *
 * @author Itay
 */
public class Cliente implements Serializable{
    
    private int id_cliente;
    private String cpf_cliente;
    private String nome_cliente;
    private String email_cliente;
    private String data_cliente;
    private String rua_cliente;
    private int nr_cliente;
    private String cep_cliente;
    private int id_cidade;
    private int id_estado;
    
    public Cliente(){
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getData_cliente() {
        return data_cliente;
    }

    public void setData_cliente(String data_cliente) {
        this.data_cliente = data_cliente;
    }

    public String getRua_cliente() {
        return rua_cliente;
    }

    public void setRua_cliente(String rua_cliente) {
        this.rua_cliente = rua_cliente;
    }

    public int getNr_cliente() {
        return nr_cliente;
    }

    public void setNr_cliente(int nr_cliente) {
        this.nr_cliente = nr_cliente;
    }

    public String getCep_cliente() {
        return cep_cliente;
    }

    public void setCep_cliente(String cep_cliente) {
        this.cep_cliente = cep_cliente;
    }

    public int getCidade_cliente() {
        return id_cidade;
    }

    public void setCidade_cliente(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public int getEstado_cliente() {
        return id_estado;
    }

    public void setEstado_cliente(int id_estado) {
        this.id_estado = id_estado;
    }
    
}
