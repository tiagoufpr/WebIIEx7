/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;
import com.ufpr.tads.web2.beans.Cidade;
import com.ufpr.tads.web2.dao.CidadeDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Itay
 */
public class CidadesFacade {
    public static void inserir(Cidade cidade) throws SQLException, ClassNotFoundException {
        CidadeDAO dao = new CidadeDAO();
        dao.insertCidade(cidade.getNomeCidade());
    }

    public static void alterar(Cidade cidade) throws SQLException, ClassNotFoundException {
        CidadeDAO dao = new CidadeDAO();
        dao.alterarCidade(cidade.getNomeCidade(), cidade.getIdCidade());
    }

    public static Cidade buscar(int id) throws SQLException, ClassNotFoundException {
        CidadeDAO dao = new CidadeDAO();
        return dao.selectCidadeEspecifica(id);
    }

    public static List<Cidade> buscarTodos() throws SQLException, ClassNotFoundException {
        CidadeDAO dao = new CidadeDAO();
        return dao.selectCidades();
    }

    public static void excluir(int id) throws SQLException, ClassNotFoundException {
        CidadeDAO dao = new CidadeDAO();
        dao.removeCidade(id);
    }
}
