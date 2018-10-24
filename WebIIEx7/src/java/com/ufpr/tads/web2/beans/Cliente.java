/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Itay
 */
public class Cliente implements Serializable{
    
    private int idCliente;
    private String cpfCliente;
    private String nomeCliente;
    private String emailCliente;
    private Date dataCliente;
    private String ruaCliente;
    private int nrCliente;
    private String cepCliente;
    private int idCidade;
    private String NomeCidade;
    private int idEstado;
    private String NomeEstado;
    
    public Cliente(){
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Date getDataCliente() {
        return dataCliente;
    }

    public void setDataCliente(Date dataCliente) {
        this.dataCliente = dataCliente;
    }

    public String getRuaCliente() {
        return ruaCliente;
    }

    public void setRuaCliente(String ruaCliente) {
        this.ruaCliente = ruaCliente;
    }

    public int getNrCliente() {
        return nrCliente;
    }

    public void setNrCliente(int nrCliente) {
        this.nrCliente = nrCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public int getCidadeCliente() {
        return idCidade;
    }

    public void setCidadeCliente(int idCidade) {
        this.idCidade = idCidade;
    }

    public int getEstadoCliente() {
        return idEstado;
    }

    public void setEstadoCliente(int idEstado) {
        this.idEstado = idEstado;
    }
    
        public String getNomeCidade() {
        return NomeCidade;
    }

    public void setNomeCidade(String NomeCidade) {
        this.NomeCidade = NomeCidade;
    }

    public String getNomeEstado() {
        return NomeEstado;
    }

    public void setNomeEstado(String NomeEstado) {
        this.NomeEstado = NomeEstado;
    }
}
