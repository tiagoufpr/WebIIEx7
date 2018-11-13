/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.bean.Produto;
import com.ufpr.tads.web2.dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Itay
 */
public class ProdutoFacade {
    public static void inserir(Produto produto) throws SQLException, ClassNotFoundException {
        ProdutoDAO dao = new ProdutoDAO();
        dao.insertProduto(produto);
    }

    public static void alterar(Produto produto) throws SQLException, ClassNotFoundException {
        ProdutoDAO dao = new ProdutoDAO();
        dao.alterarProduto(produto.getIdProduto(), produto.getNomeProduto());
    }

    public static Produto buscar(int id) throws SQLException, ClassNotFoundException {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.selectProdutoEspecifico(id);
    }

    public static List<Produto> buscarTodos() throws SQLException, ClassNotFoundException {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.selectProdutos();
    }

    public static void excluir(int id) throws SQLException, ClassNotFoundException {
        ProdutoDAO dao = new ProdutoDAO();
        dao.removeProduto(id);
    }
}
