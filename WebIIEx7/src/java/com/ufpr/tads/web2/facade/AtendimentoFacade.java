/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.dao.AtendimentoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Itay
 */
public class AtendimentoFacade {
    public static void inserir(Atendimento atendimento) throws SQLException, ClassNotFoundException {
        AtendimentoDAO dao = new AtendimentoDAO();
        dao.insertAtendimento(atendimento.getDtHrAtendimento(), atendimento.getDscAtendimento(), atendimento.getIdProduto(), atendimento.getIdTipoAtendimento(), atendimento.getIdUsuario(), atendimento.getIdCliente(), atendimento.getResAtendimento());
    }

    public static void alterar(Atendimento atendimento) throws SQLException, ClassNotFoundException {
        AtendimentoDAO dao = new AtendimentoDAO();
        dao.alterarAtendimento(atendimento.getDtHrAtendimento(), atendimento.getDscAtendimento(), atendimento.getIdProduto(), atendimento.getIdTipoAtendimento(), atendimento.getIdUsuario(), atendimento.getIdCliente(), atendimento.getResAtendimento(), atendimento.getIdAtendimento());
    }

    public static Atendimento buscar(int id) throws SQLException, ClassNotFoundException {
        AtendimentoDAO dao = new AtendimentoDAO();
        return dao.selectAtendimentoEspecifico(id);
    }

    public static List<Atendimento> buscarTodos() throws SQLException, ClassNotFoundException {
        AtendimentoDAO dao = new AtendimentoDAO();
        return dao.selectAtendimentos();
    }

    public static void excluir(int id) throws SQLException, ClassNotFoundException {
        AtendimentoDAO dao = new AtendimentoDAO();
        dao.removeAtendimento(id);
    }
}
