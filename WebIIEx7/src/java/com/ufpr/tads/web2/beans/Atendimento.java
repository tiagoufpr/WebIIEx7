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
public class Atendimento implements Serializable{
    
    private int idAtendimento;
    private String dscAtendimento;
    private int idProduto;
    private int idTipoAtendimento;
    private Date dtHrAtendimento;
    private int idUsuario;
    private int idCliente;
    private String resAtendimento;

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public String getDscAtendimento() {
        return dscAtendimento;
    }

    public void setDscAtendimento(String dscAtendimento) {
        this.dscAtendimento = dscAtendimento;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdTipoAtendimento() {
        return idTipoAtendimento;
    }

    public void setIdTipoAtendimento(int idTipoAtendimento) {
        this.idTipoAtendimento = idTipoAtendimento;
    }

    public Date getDtHrAtendimento() {
        return dtHrAtendimento;
    }

    public void setDtHrAtendimento(Date dtHrAtendimento) {
        this.dtHrAtendimento = dtHrAtendimento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getResAtendimento() {
        return resAtendimento;
    }

    public void setResAtendimento(String resAtendimento) {
        this.resAtendimento = resAtendimento;
    }
}
