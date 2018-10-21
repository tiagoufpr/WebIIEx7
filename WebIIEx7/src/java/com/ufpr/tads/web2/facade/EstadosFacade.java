/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;
import com.ufpr.tads.web2.beans.Estado;
import com.ufpr.tads.web2.dao.EstadoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Itay
 */
public class EstadosFacade {
    public static void inserir(Estado estado) throws SQLException, ClassNotFoundException {
        EstadoDAO dao = new EstadoDAO();
        dao.insertEstado(estado.getNomeEstado());
    }

    public static void alterar(Estado estado) throws SQLException, ClassNotFoundException {
        EstadoDAO dao = new EstadoDAO();
        dao.alterarEstado(estado.getNomeEstado(), estado.getIdEstado());
    }

    public static Estado buscar(int id) throws SQLException, ClassNotFoundException {
        EstadoDAO dao = new EstadoDAO();
        return dao.selectEstadoEspecifico(id);
    }

    public static List<Estado> buscarTodos() throws SQLException, ClassNotFoundException {
        EstadoDAO dao = new EstadoDAO();
        return dao.selectEstados();
    }

    public static void excluir(int id) throws SQLException, ClassNotFoundException {
        EstadoDAO dao = new EstadoDAO();
        dao.removeEstado(id);
    }
}
